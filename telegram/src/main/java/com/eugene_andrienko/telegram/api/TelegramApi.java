package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
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

    // TODO: Send as reply to previous message with audio/video
    /**
     * Send a message to "Saved Messages" chat.
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

    // TODO: add description in the same message
    /**
     * Uploads audio file to Telegram.
     *
     * @param audio Audio file to upload
     *
     * @return Local file ID.
     *
     * @throws TelegramUploadFileException Upload audio fail.
     */
    public int uploadAudio(File audio) throws TelegramUploadFileException
    {
        CompletableFuture<Integer> result = telegram.uploadAudio(audio);
        Integer localId;
        try
        {
            localId = result.get(delaySeconds, TimeUnit.SECONDS);
        }
        catch(InterruptedException | ExecutionException | TimeoutException e)
        {
            throw new TelegramUploadFileException(e);
        }
        return localId;
    }

    /**
     * Send audio file to Telegram.
     *
     * @param localId Local ID of audio file.
     *
     * @throws TelegramSendMessageException Failed send audio
     */
    public void sendAudio(int localId) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = telegram.sendAudio(localId);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send audio to Telegram");
        }
    }

    /**
     * Uploads a video file to Telegram.
     *
     * @param video The video file to upload
     *
     * @return Local file ID.
     *
     * @throws TelegramUploadFileException Upload video fail.
     */
    public int uploadVideo(File video) throws TelegramUploadFileException
    {
        CompletableFuture<Integer> result = telegram.uploadVideo(video);
        Integer localId;
        try
        {
            localId = result.get(delaySeconds, TimeUnit.SECONDS);
        }
        catch(InterruptedException | ExecutionException | TimeoutException e)
        {
            throw new TelegramUploadFileException(e);
        }
        return localId;
    }

    /**
     * Send a video file to Telegram.
     *
     * @param localId Local ID of video file.
     *
     * @throws TelegramSendMessageException Failed to send video
     */
    public void sendVideo(int localId) throws TelegramSendMessageException
    {
        CompletableFuture<Boolean> result = telegram.sendVideo(localId);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send video to Telegram");
        }
    }

    /**
     * Returns uploading progress in percents of given file.
     *
     * @param localId Local file ID.
     *
     * @return Uploading progress in percents.
     *
     * @throws TelegramUploadFileException Fail to get uploading progress for given local ID.
     */
    public float getUploadingProgress(Integer localId) throws TelegramUploadFileException
    {
        return telegram.getUploadingProgress(localId);
    }

    /**
     * Logout from Telegram and free acquired resources.
     *
     * @throws Exception Fail to close Telegram library.
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
