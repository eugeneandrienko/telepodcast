package com.eugene_andrienko.telegram.impl;

import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.*;
import com.eugene_andrienko.telegram.impl.TelegramTDLibConnector.MessageSenderState;
import com.eugene_andrienko.telegram.impl.TelegramTDLibConnector.MessageType;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.ImmutablePair;


/**
 * Sends files and messages to "Saved messages" chat in Telegram.
 * Also hides complexity of TDLib inside itself.
 */
@Slf4j
public class Telegram implements AutoCloseable
{
    private final TelegramTDLibConnector telegramConnector;

    private final int loadingChatsLimit;
    private final AtomicLong savedMessagesId = new AtomicLong(0);
    private final static int DEFAULT_RESEND_RETRIES = 2;
    private final int resendRetries;

    /**
     * Initializes Telegram library.
     *
     * @param options Initialized {@code TelegramOptions} object.
     *
     * @throws TelegramInitException Got wrong credentials.
     */
    public Telegram(TelegramOptions options) throws TelegramInitException
    {
        if(options.getLoadingChatsLimit() < 1)
        {
            log.error("Limit of chats to load is less than 1");
            throw new TelegramInitException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = options.getLoadingChatsLimit();
        if(options.getResendRetries() < 0)
        {
            log.error("Wrong count of resend retries: {}!", options.getResendRetries());
            throw new TelegramInitException("Resend retries < 0");
        }
        this.resendRetries = options.getResendRetries();
        telegramConnector = new TelegramTDLibConnector(options);
        //logger.debug("Telegram options: {}", options);
    }

    /**
     * Initializes Telegram library.
     *
     * @param telegramConnector Initialized {@code TelegramTDLibConnector} object
     * @param loadingChatsLimit Limit of chats to load from Telegram chat list
     * @param resendRetries     Count of resend retries, when sending message fails
     *
     * @throws TelegramInitException Got wrong credentials.
     */
    Telegram(TelegramTDLibConnector telegramConnector, int loadingChatsLimit, int resendRetries)
            throws TelegramInitException
    {
        if(loadingChatsLimit < 1)
        {
            log.error("Limit of chats to load is less than 1");
            throw new TelegramInitException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = loadingChatsLimit;
        if(resendRetries < 0)
        {
            log.error("Wrong count of resend retries: {}!", resendRetries);
            throw new TelegramInitException("Resend retries < 0");
        }
        this.resendRetries = resendRetries;
        this.telegramConnector = telegramConnector;
    }

    /**
     * Initializes Telegram library.
     *
     * @param telegramConnector Initialized {@code Telegram} object.
     * @param loadingChatsLimit Limit of chats to load from Telegram chat list
     *
     * @throws TelegramInitException Got wrong credentials.
     */
    Telegram(TelegramTDLibConnector telegramConnector, int loadingChatsLimit)
            throws TelegramInitException
    {
        if(loadingChatsLimit < 1)
        {
            log.error("Limit of chats to load is less than 1");
            throw new TelegramInitException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = loadingChatsLimit;
        this.resendRetries = DEFAULT_RESEND_RETRIES;
        this.telegramConnector = telegramConnector;
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
     *
     * @throws TelegramInitException Failed to initialize TDLib.
     */
    public void login() throws TelegramInitException
    {
        log.debug("Logging into Telegram");
        // Initialize TDLib and login to Telegram:
        telegramConnector.init().thenCompose(initComplete -> {
            CompletableFuture<Boolean> result = new CompletableFuture<>();
            if(initComplete)
            {
                log.info("Logged into Telegram account");

                log.info("Loading chat list (limit {})...", loadingChatsLimit);
                // Loading chat lists:
                telegramConnector.loadChatList(loadingChatsLimit);
                result = telegramConnector.isChatListLoaded(loadingChatsLimit);
            }
            else
            {
                log.error("Cannot login to Telegram");
                result.completeExceptionally(new TelegramAuthException("Cannot login"));
            }
            return result;
        }).thenCompose(chatsLoaded -> {
            CompletableFuture<String> result = new CompletableFuture<>();
            if(chatsLoaded)
            {
                log.info("Loaded chat list");
                // Getting username to get "Saved Messages" chat id:
                result = telegramConnector.getSavedMessagesChatName();
            }
            else
            {
                log.error("Cannot load chat list");
                result.completeExceptionally(
                        new TelegramChatNotFoundException("Cannot load chat list"));
            }
            return result;
        }).thenCompose(chatName -> {
            // Loading "Saved Messages" chat id:
            //noinspection Convert2MethodRef
            return telegramConnector.getSavedMessagesChatId(chatName);
        }).thenAccept(id -> {
            this.savedMessagesId.set(id);
            log.info("Loaded \"Saved Messages\" chat: {}", this.savedMessagesId);
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
        log.debug("Logging out from Telegram");
        telegramConnector.close();
        log.info("Logout from Telegram");
    }

    /**
     * Asynchronously uploads audio file to Telegram.
     *
     * @param file Audio file to upload.
     *
     * @return {@code CompletableFuture} with local ID of uploaded file.
     */
    public CompletableFuture<Integer> uploadAudio(File file)
    {
        log.info("Uploading audio: {}", file.getAbsolutePath());
        return telegramConnector.uploadFile(file, MessageType.AUDIO);
    }

    /**
     * Asynchronously uploads a video file to Telegram.
     *
     * @param file The video file to upload.
     *
     * @return {@code CompletableFuture} with local ID of uploaded file.
     */
    public CompletableFuture<Integer> uploadVideo(File file)
    {
        log.info("Uploading video: {}", file.getAbsolutePath());
        return telegramConnector.uploadFile(file, MessageType.VIDEO);
    }

    /**
     * Returns uploading progress (in percents) of file.
     *
     * @param localId Local file ID.
     *
     * @return Uploading progress in percents.
     *
     * @throws TelegramUploadFileException Fail to get uploading progress for given local ID.
     */
    public float getUploadingProgress(int localId) throws TelegramUploadFileException
    {
        return telegramConnector.getUploadFileProgress(localId);
    }

    /**
     * Sends message to "Saved Messages" chat.
     *
     * @param message   Message to send
     * @param replyToId Message ID to reply to. Can be zero to send message not as reply.
     *
     * @return {@code CompletableFuture} with {@code ImmutablePair} inside. If first element of
     * {@code ImmutablePair} is {@code true} if message sent and {@code false} if not. Second
     * element of {@code ImmutablePair} — local ID of message sent.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the message.
     */
    public CompletableFuture<ImmutablePair<Boolean, Long>> sendMessage(String message,
            long replyToId)
            throws TelegramSendMessageException
    {
        CompletableFuture<ImmutablePair<Boolean, Long>> result = sendMessage(message,
                MessageType.TEXT, replyToId, resendRetries, null);
        return result.handle((res, ex) -> {
            if(ex == null && res != null && res.getLeft())
            {
                log.info("Message |{}| sending", message.substring(0,
                        Math.min(message.length(), 80)));
            }
            return res;
        });
    }

    /**
     * Returning {@code CompletableFuture} with server message ID.
     *
     * @param localMessageId Local message ID
     *
     * @return {@code CompletableFuture} with server message ID.
     */
    public CompletableFuture<Long> getServerMessageId(long localMessageId)
    {
        return telegramConnector.getServerMessageId(localMessageId);
    }

    /**
     * Sends audio to "Saved Messages" chat.
     *
     * @param audioLocalId Local ID of previously uploaded audio file
     * @param description  Description of audio. May be null.
     * @param duration     Duration of audio in seconds. May be zero.
     * @param replyToId    Message ID to reply to. Can be zero to send message not as reply.
     *
     * @return {@code CompletableFuture} with {@code ImmutablePair} inside. If first element of
     * {@code ImmutablePair} is {@code true} if message sent and {@code false} if not. Second
     * element of {@code ImmutablePair} — local ID of message sent.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the audio.
     */
    public CompletableFuture<ImmutablePair<Boolean, Long>> sendAudio(Integer audioLocalId,
            String description, int duration, long replyToId) throws TelegramSendMessageException
    {
        ImmutablePair<String, Integer> additionalData = ImmutablePair.of(description, duration);
        CompletableFuture<ImmutablePair<Boolean, Long>> result = sendMessage(audioLocalId,
                MessageType.AUDIO, replyToId, resendRetries, additionalData);
        return result.handle((res, ex) -> {
            if(ex == null && res != null && res.getLeft())
            {
                log.info("Audio with id = {} sending", audioLocalId);
            }
            return res;
        });
    }

    /**
     * Sends video to "Saved Messages" chat.
     *
     * @param videoLocalId Local ID of previously uploaded video file
     * @param description  Description of video. May be null.
     * @param duration     Duration of video in seconds. May be zero.
     * @param replyToId    Message ID to reply to. Can be zero to send message not as reply.
     *
     * @return {@code CompletableFuture} with {@code ImmutablePair} inside. If first element of
     * {@code ImmutablePair} is {@code true} if message sent and {@code false} if not. Second
     * element of {@code ImmutablePair} — local ID of message sent.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the video.
     */
    public CompletableFuture<ImmutablePair<Boolean, Long>> sendVideo(Integer videoLocalId,
            String description, int duration, long replyToId) throws TelegramSendMessageException
    {
        ImmutablePair<String, Integer> additionalData = ImmutablePair.of(description, duration);
        CompletableFuture<ImmutablePair<Boolean, Long>> result = sendMessage(videoLocalId,
                MessageType.VIDEO, replyToId, resendRetries, additionalData);
        return result.handle((res, ex) -> {
            if(ex == null && res != null && res.getLeft())
            {
                log.info("Video with id = {} sending", videoLocalId);
            }
            return res;
        });
    }


    /**
     * Sends a message to "Saved Messages" chat.
     *
     * @param message     Message or local file ID to send
     * @param messageType Message type
     * @param replyToId   Message ID to reply to. Can be zero to send message not as reply
     * @param resendTry   Count of resend tries. When count < 0 — all resend tries exhausted
     * @param additional  Additional data to send with message
     *
     * @return {@code CompletableFuture} with {@code ImmutablePair} inside. If first element of
     * {@code ImmutablePair} is {@code true} if message sent and {@code false} if not. Second
     * element of {@code ImmutablePair} — ID of message sent.
     *
     * @throws TelegramSendMessageException Got unexpected error when sending the message.
     */
    @SneakyThrows(InterruptedException.class)
    private CompletableFuture<ImmutablePair<Boolean, Long>> sendMessage(Object message,
            MessageType messageType, long replyToId, int resendTry,
            ImmutablePair<String, Integer> additional)
            throws TelegramSendMessageException
    {
        CompletableFuture<ImmutablePair<Boolean, Long>> result = new CompletableFuture<>();
        if(resendTry < 0)
        {
            log.error("Exhaust of resend tries - cannot send message!");
            result.complete(ImmutablePair.of(false, 0L));
            return result;
        }
        if(message == null)
        {
            log.error("Got null as message to send");
            result.complete(ImmutablePair.of(false, 0L));
            return result;
        }

        CompletableFuture<ImmutablePair<MessageSenderState, Long>> sendMessageResult =
                telegramConnector.sendMessage(savedMessagesId.get(), messageType, message,
                        replyToId, additional);

        try
        {
            long messageId = sendMessageResult.get().getRight();
            switch(sendMessageResult.get().getLeft())
            {
                case OK -> result.complete(ImmutablePair.of(true, messageId));
                case FAIL -> result.complete(ImmutablePair.of(false, messageId));
                case RETRY ->
                {
                    log.debug("Resending message: try #{}", resendRetries - resendTry + 1);
                    return sendMessage(message, messageType, replyToId, --resendTry, additional);
                }
            }
        }
        catch(ExecutionException ex)
        {
            throw new TelegramSendMessageException(ex);
        }
        return result;
    }
}
