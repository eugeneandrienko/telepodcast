package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramAuthException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramChatNotFoundException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.impl.Telegram;
import com.eugene_andrienko.telegram.impl.Telegram.MessageType;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Sends files and messages to "Saved messages" chat in Telegram.
 *
 * Also hides complexity of TDLib inside itself.
 */
public class TelegramApi implements AutoCloseable
{
    private final Telegram telegram;
    private final Logger logger = LoggerFactory.getLogger(TelegramApi.class);

    private final int loadingChatsLimit;
    private final AtomicLong savedMessagesId = new AtomicLong(0);
    private final static int DEFAULT_RESEND_RETRIES = 2;
    private final int resendRetries;

    /**
     * Initializes Telegram library.
     *
     * @param apiId             Telegram API ID
     * @param apiHash           Telegram API hash
     * @param loadingChatsLimit Limit of chats to load from Telegram chat list
     * @param debug             Debug mode
     *
     * @throws TelegramAuthException Got wrong credentials.
     */
    public TelegramApi(int apiId, String apiHash, int loadingChatsLimit, boolean debug)
            throws TelegramAuthException
    {
        if(loadingChatsLimit < 1)
        {
            logger.error("Limit of chats to load is less than 1");
            throw new TelegramAuthException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = loadingChatsLimit;
        this.resendRetries = DEFAULT_RESEND_RETRIES;
        telegram = new Telegram(apiId, apiHash, debug);
        //logger.debug("API ID: |{}|, API hash: |{}|", apiId, apiHash);
    }

    /**
     * Initializes Telegram library.
     *
     * @param telegram          Initialized {@code Telegram} object
     * @param loadingChatsLimit Limit of chats to load from Telegram chat list
     * @param resendRetries     Count of resend retries, when sending message fails
     *
     * @throws TelegramAuthException Got wrong credentials.
     */
    TelegramApi(Telegram telegram, int loadingChatsLimit, int resendRetries)
            throws TelegramAuthException
    {
        if(loadingChatsLimit < 1)
        {
            logger.error("Limit of chats to load is less than 1");
            throw new TelegramAuthException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = loadingChatsLimit;
        if(resendRetries < 0)
        {
            logger.error("Wrong count of resend retries: {}!", resendRetries);
            throw new TelegramAuthException("Resend retries < 0");
        }
        this.resendRetries = resendRetries;
        this.telegram = telegram;
    }

    /**
     * Initializes Telegram library.
     *
     * @param telegram          Initialized {@code Telegram} object.
     * @param loadingChatsLimit Limit of chats to load from Telegram chat list
     *
     * @throws TelegramAuthException Got wrong credentials.
     */
    TelegramApi(Telegram telegram, int loadingChatsLimit) throws TelegramAuthException
    {
        if(loadingChatsLimit < 1)
        {
            logger.error("Limit of chats to load is less than 1");
            throw new TelegramAuthException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = loadingChatsLimit;
        this.resendRetries = DEFAULT_RESEND_RETRIES;
        this.telegram = telegram;
    }

    /**
     * Performs login to Telegram.
     *
     * Method does the next operations:
     * <ul>
     *     <li>Login to Telegram via TDLib</li>
     *     <li>Loading {@code loadingChatsLimit} chats from Telegram chat list</li>
     *     <li>Searching for "Saved Messages" chat id</li>
     * </ul>
     *
     * All these operations performs asynchronously and this method returns <b>immediately</b>!
     * To check what all is completed successfully — use {@code isReady} method like this:
     * {@code if(telegram.isReady().get(30, TimeUnit.SECONDS)) ...}
     */
    public void login()
    {
        logger.debug("Logging into Telegram");
        // Initialize TDLib and login to Telegram:
        telegram.init().thenCompose(initComplete -> {
            CompletableFuture<Boolean> result = new CompletableFuture<>();
            if(initComplete)
            {
                logger.info("Logged into Telegram account");

                logger.info("Loading chat list (limit {})...", loadingChatsLimit);
                // Loading chat lists:
                telegram.loadChatList(loadingChatsLimit);
                result = telegram.isChatListLoaded(loadingChatsLimit);
            }
            else
            {
                logger.error("Cannot login to Telegram");
                result.completeExceptionally(new TelegramAuthException("Cannot login"));
            }
            return result;
        }).thenCompose(chatsLoaded -> {
            CompletableFuture<String> result = new CompletableFuture<>();
            if(chatsLoaded)
            {
                logger.info("Loaded chat list");
                // Getting username to get "Saved Messages" chat id:
                result = telegram.getSavedMessagesChatName();
            }
            else
            {
                logger.error("Cannot load chat list");
                result.completeExceptionally(
                        new TelegramChatNotFoundException("Cannot load chat list"));
            }
            return result;
        }).thenCompose(chatName -> {
            // Loading "Saved Messages" chat id:
            //noinspection Convert2MethodRef
            return telegram.getSavedMessagesChatId(chatName);
        }).thenAccept(id -> {
            this.savedMessagesId.set(id);
            logger.info("Loaded \"Saved Messages\" chat: {}", this.savedMessagesId);
        });
    }

    /**
     * Check what Telegram login and load of "Saved Messages" chat ID are successfully.
     *
     * Method should be used, like this:
     * {@code if(telegram.isReady().get(30, TimeUnit.SECONDS)) ...}
     *
     * @return {@code CompletableFuture} with {@code TelegramApi} status.
     */
    public CompletableFuture<Boolean> isReady()
    {
        return CompletableFuture.supplyAsync(() -> {
            while(this.savedMessagesId.get() == 0)
            {
                Thread.yield();
            }
            return true;
        });
    }

    /**
     * Logout from Telegram.
     */
    @Override
    public void close() throws Exception
    {
        logger.debug("Logging out from Telegram");
        telegram.close();
        logger.info("Logout from Telegram");
    }

    /**
     * Sends message to "Saved Messages" chat.
     *
     * @param message Message to send
     *
     * @return {@code CompletableFuture} with {@code true} if message sent and {@code false} if not.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the message.
     */
    public CompletableFuture<Boolean> sendMessage(String message)
            throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = sendMessage(message, MessageType.TEXT, resendRetries);
        result.whenCompleteAsync((res, ex) -> {
            if(ex == null && res)
            {
                logger.debug("Message |{}| sent", message.substring(0,
                        Math.min(message.length(), 80)));
            }
        });
        return result;
    }

    /**
     * Sends audio to "Saved Messages" chat.
     *
     * @param audio Audio file to send
     *
     * @return {@code CompletableFuture} with {@code true} if audio sent and {@code false} if not.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the audio.
     */
    public CompletableFuture<Boolean> sendAudio(File audio) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = sendMessage(audio, MessageType.AUDIO, resendRetries);
        result.whenCompleteAsync((res, ex) -> {
            if(ex == null && res)
            {
                logger.info("Audio {} sent", audio.getName());
            }
        });
        return result;
    }

    /**
     * Sends video to "Saved Messages" chat.
     *
     * @param video Video file to send
     *
     * @return {@code CompletableFuture} with {@code true} if video sent and {@code false} if not.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the video.
     */
    public CompletableFuture<Boolean> sendVideo(File video) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = sendMessage(video, MessageType.VIDEO, resendRetries);
        result.whenCompleteAsync((res, ex) -> {
            if(ex == null && res)
            {
                logger.info("Video {} sent", video.getName());
            }
        });
        return result;
    }


    /**
     * Sends message to "Saved Messages" chat.
     *
     * @param message     Message to send
     * @param messageType Message type
     * @param resendTry   Count of resend tries. When count < 0 — all resend tries exhausted.
     *
     * @return {@code CompletableFuture} with {@code true} if message sent and {@code false} if not.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the message.
     */
    @SneakyThrows(InterruptedException.class)
    private CompletableFuture<Boolean> sendMessage(Object message, MessageType messageType,
            int resendTry) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = new CompletableFuture<>();
        if(resendTry < 0)
        {
            logger.error("Exhaust of resend tries - cannot send message!");
            result.complete(false);
            return result;
        }

        CompletableFuture<Telegram.MessageSenderState> sendMessageResult = telegram.sendMessage(
                savedMessagesId.get(), messageType, message);

        try
        {
            switch(sendMessageResult.get())
            {
                case OK:
                    result.complete(true);
                    break;
                case FAIL:
                    result.complete(false);
                    break;
                case RETRY:
                    logger.debug("Resending message: try #{}", resendRetries - resendTry + 1);
                    return sendMessage(message, messageType, --resendTry);
            }
        }
        catch(ExecutionException ex)
        {
            throw new TelegramSendMessageException(ex);
        }
        return result;
    }
}
