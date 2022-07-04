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
import org.javatuples.Pair;
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

    public static final int MEDIA_CAPTION_LENGTH = 1024;
    public static final int MESSAGE_LENGTH = 4096;

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
        try
        {
            boolean loginState = result.get(delaySeconds, TimeUnit.SECONDS);
            if(!loginState)
            {
                throw new TelegramInitException("Failed to login to Telegram");
            }
        }
        catch(TimeoutException | InterruptedException | ExecutionException e)
        {
            throw new TelegramInitException("Failed to login to Telegram");
        }
    }

    /**
     * Send a message to "Saved Messages" chat.
     *
     * @param message   Message to send.
     * @param replyToId Message ID to reply to. Can be 0 to send message not as reply.
     *
     * @return Message ID
     *
     * @throws TelegramSendMessageException Failed to send message
     */
    public long sendMessage(String message, long replyToId) throws TelegramSendMessageException
    {
        if(message == null || message.length() > MESSAGE_LENGTH)
        {
            logger.warn("Cannot send message. Message size: {}, limit: {}?",
                    message != null ? message.length() : 0, MESSAGE_LENGTH);
            throw new TelegramSendMessageException("Too long message");
        }
        if(message.isEmpty())
        {
            logger.warn("Cannot send message — it's empty");
            throw new TelegramSendMessageException("Message empty");
        }
        CompletableFuture<Pair<Boolean, Long>> result = telegram.sendMessage(message, replyToId);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send message to Telegram");
        }
        long localMessageId = getLocalMessageId(result);
        return getServerMessageId(telegram.getServerMessageId(localMessageId));
    }

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
     * @param localId     Local ID of audio file.
     * @param description Description of audio file or {@code null} if no description.
     * @param duration    Duration of audio in seconds or 0 if no duration.
     * @param replyToId   Message ID to reply to. Can be 0 to send message not as reply.
     *
     * @return Message ID
     *
     * @throws TelegramSendMessageException Failed send audio
     */
    public long sendAudio(int localId, String description, int duration, long replyToId)
            throws TelegramSendMessageException
    {
        if(description != null && description.length() > MEDIA_CAPTION_LENGTH)
        {
            logger.warn("Audio description too long to send. Description size: {}, limit: {}",
                    description.length(), MEDIA_CAPTION_LENGTH);
            throw new TelegramSendMessageException("Too long audio description");
        }

        CompletableFuture<Pair<Boolean, Long>> result = telegram.sendAudio(localId, description,
                duration, replyToId);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send audio to Telegram");
        }
        long localMessageId = getLocalMessageId(result);
        return getServerMessageId(telegram.getServerMessageId(localMessageId));
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
     * @param localId     Local ID of video file.
     * @param description Description of video file or {@code null} if no description.
     * @param replyToId   Message ID to reply to. Can be 0 to send message not as reply.
     *
     * @return Message ID
     *
     * @throws TelegramSendMessageException Fail send video
     */
    public long sendVideo(int localId, String description, int duration, long replyToId)
            throws TelegramSendMessageException
    {
        if(description != null && description.length() > MEDIA_CAPTION_LENGTH)
        {
            logger.warn("Video description too long to send. Description size: {}, limit: {}",
                    description.length(), MEDIA_CAPTION_LENGTH);
            throw new TelegramSendMessageException("Too long video description");
        }

        CompletableFuture<Pair<Boolean, Long>> result = telegram.sendVideo(localId, description,
                duration, replyToId);
        if(isTelegramMethodFailed(result))
        {
            throw new TelegramSendMessageException("Failed to send video to Telegram");
        }
        long localMessageId = getLocalMessageId(result);
        return getServerMessageId(telegram.getServerMessageId(localMessageId));
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
    private boolean isTelegramMethodFailed(CompletableFuture<Pair<Boolean, Long>> completable)
    {
        try
        {
            return !completable.get(delaySeconds, TimeUnit.SECONDS).getValue0();
        }
        catch(InterruptedException | TimeoutException | ExecutionException e)
        {
            logger.debug("CompletableFuture<Boolean>.get() failed", e);
            return true;
        }
    }

    private long getLocalMessageId(CompletableFuture<Pair<Boolean, Long>> completable)
    {
        try
        {
            return completable.get(delaySeconds, TimeUnit.SECONDS).getValue1();
        }
        catch(InterruptedException | TimeoutException | ExecutionException e)
        {
            logger.error("Failed to get message ID");
            return 0L;
        }
    }

    private long getServerMessageId(CompletableFuture<Long> completable)
    {
        try
        {
            return completable.get(delaySeconds, TimeUnit.SECONDS);
        }
        catch(InterruptedException | TimeoutException | ExecutionException e)
        {
            logger.error("Failed to get message ID");
            return 0L;
        }
    }
}
