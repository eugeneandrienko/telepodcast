package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramAuthException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramChatNotFoundException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;
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
        telegram = new Telegram(apiId, apiHash, debug);
        //logger.debug("API ID: |{}|, API hash: |{}|", apiId, apiHash);
    }

    /**
     * Initializes Telegram library.
     *
     * @param telegram          Initialized {@code Telegram} object.
     * @param loadingChatsLimit Limit of chats to load from Telegram chat list
     * @param debug             Debug mode
     *
     * @throws TelegramAuthException Got wrong credentials.
     */
    public TelegramApi(Telegram telegram, int loadingChatsLimit, boolean debug)
            throws TelegramAuthException
    {
        if(loadingChatsLimit < 1)
        {
            logger.error("Limit of chats to load is less than 1");
            throw new TelegramAuthException("Limit of chats to load < 1");
        }
        this.loadingChatsLimit = loadingChatsLimit;
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

    public void sendMessage(String message)
    {
    }

    public void sendFile(File file)
    {
    }
}
