package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Supplier;
import lombok.SneakyThrows;
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
     * @param options Initialized {@code TelegramOptions} object.
     *
     * @throws TelegramInitException Failed to initialize API.
     */
    public TelegramApi(TelegramOptions options) throws TelegramInitException
    {
        telegram = new Telegram(options);
        this.delaySeconds = options.getDelaySeconds();
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
        waitForMessageInChat(() -> telegram.isMessageInChat(message));
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
        waitForMessageInChat(() -> telegram.isAudioInChat(audio));
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
        waitForMessageInChat(() -> telegram.isVideoInChat(video));
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

    /**
     * Waits for the message near {@code delaySeconds} seconds.
     *
     * @param supplier {@code Supplier} to check message appears in chat
     *
     * @throws TelegramSendMessageException Message not in chat
     */
    @SneakyThrows(ExecutionException.class)
    private void waitForMessageInChat(Supplier<CompletableFuture<Boolean>> supplier)
            throws TelegramSendMessageException
    {
        for(int i = 0; i < delaySeconds; i++)
        {
            try
            {
                if(supplier.get().get(delaySeconds, TimeUnit.SECONDS))
                {
                    return;
                }
                Thread.sleep(1000);
                Thread.yield();
            }
            catch(InterruptedException e)
            {
                logger.error("Sleep in waitForMessageInChat interrupted!");
            }
            catch(TimeoutException e)
            {
                logger.error("Timeout when waiting for message");
                throw new TelegramSendMessageException("Timeout when waiting for message");
            }
        }
        throw new TelegramSendMessageException("Failed to see sent audio in Telegram");
    }
}
