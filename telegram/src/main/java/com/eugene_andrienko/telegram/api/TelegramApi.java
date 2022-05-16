package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Synchronous API for Telegram. Based on the TDLib.
 */
public class TelegramApi implements AutoCloseable
{
    private final Telegram telegram;
    private final int delaySeconds;
    private final Logger logger = LoggerFactory.getLogger(TelegramApi.class);

    /**
     * Initializes Telegram library.
     *
     * @param apiId             Telegram API ID
     * @param apiHash           Telegram API hash
     * @param loadingChatsLimit Count of chats from chat list, where to search "Saved Messages"
     *                          chat.
     * @param resendRetries     Count of resend retries, when sending message fails
     * @param delaySeconds      Delay in seconds to complete any library call.
     * @param debug             Enable debug mode
     *
     * @throws TelegramInitException Failed to initialize API.
     */
    public TelegramApi(int apiId, String apiHash, int loadingChatsLimit,
            int resendRetries, int delaySeconds, boolean debug) throws TelegramInitException
    {
        telegram = new Telegram(apiId, apiHash, loadingChatsLimit, resendRetries, debug);
        this.delaySeconds = delaySeconds;
    }

    /**
     * Initializes Telegram library (for test).
     *
     * @param telegram     Initialized {@code Telegram} object.
     * @param delaySeconds Delay in seconds to complete any library call.
     */
    TelegramApi(Telegram telegram, int delaySeconds)
    {
        this.telegram = telegram;
        this.delaySeconds = delaySeconds;
    }

    /**
     * Login to Telegram.
     *
     * @throws TelegramInitException Failed to login
     */
    public void login() throws TelegramInitException
    {
        telegram.login();
        CompletableFuture<Boolean> result = telegram.isReady();
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramInitException("Failed to login to Telegram");
        }
    }

    /**
     * Send message to "Saved Messages" chat.
     *
     * @param message Message to send.
     *
     * @throws TelegramSendMessageException Failed to send message
     */
    public void sendMessage(String message) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = telegram.sendMessage(message);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send message to Telegram");
        }
    }

    /**
     * Send audio file to Telegram.
     *
     * @param audio Audio file to send.
     *
     * @throws TelegramSendMessageException Failed to send audio
     */
    public void sendAudio(File audio) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = telegram.sendAudio(audio);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send audio to Telegram");
        }
    }

    /**
     * Send video file to Telegram.
     *
     * @param video Video file to send.
     *
     * @throws TelegramSendMessageException Failed to send video
     */
    public void sendVideo(File video) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = telegram.sendVideo(video);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send video to Telegram");
        }
    }

    /**
     * Logout from Telegram and free acquired resources.
     *
     * @throws Exception Failed to close Telegram library.
     */
    @Override
    public void close() throws Exception
    {
        telegram.close();
    }

    /**
     * Check result of {@code Telegram} methods.
     *
     * If result of method is false or method failed with exception — returns {@code true}. If
     * method completed successfully — returns {@code false}.
     *
     * @param completable Result of {@code Telegram} method.
     *
     * @return {@code true} if {@code Telegram} method fails, otherwise false.
     */
    private boolean isTelegramMethodFailed(CompletableFuture<Boolean> completable)
    {
        try
        {
            return !completable.get(delaySeconds, TimeUnit.SECONDS);
        }
        catch(InterruptedException | TimeoutException | ExecutionException e)
        {
            logger.debug("CompletableFuture<Boolean>.get() failed", e);
            return true;
        }
    }
}
