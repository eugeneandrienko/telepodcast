package com.eugene_andrienko.telepodcast.cli;

import com.eugene_andrienko.telegram.api.TelegramApi;
import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
import com.eugene_andrienko.telepodcast.helpers.GarbageTextRemover;
import com.eugene_andrienko.telepodcast.helpers.SimpleTextHelper;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData.ContentType;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeDownloadException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;


/**
 * CLI realization.
 */
@Slf4j
public class CLI implements AutoCloseable
{
    private TelegramApi telegram;
    private YouTubeDlApi youtube;
    private List<String> audioUrls;
    private List<String> videoUrls;

    public CLI(TelegramOptions telegramOptions, List<String> audioUrls, List<String> videoUrls,
            int downloaderThreads)
    {
        if(audioUrls.isEmpty() && videoUrls.isEmpty())
        {
            log.error("No one URL is provided!");
            return;
        }
        this.audioUrls = audioUrls;
        this.videoUrls = videoUrls;

        try
        {
            telegram = new TelegramApi(telegramOptions);
            telegram.login();
            youtube = new YouTubeDlApi(downloaderThreads);
        }
        catch(TelegramInitException ex)
        {
            log.error("Failed to login to Telegram");
        }
        catch(IOException ex)
        {
            log.error("Failed to initialize YouTube downloader");
        }
    }

    public void start()
    {
        Set<String> audioUrls = new HashSet<>(this.audioUrls);
        Set<String> videoUrls = new HashSet<>(this.videoUrls);
        audioUrls = SimpleTextHelper.removeInvalidUrls(audioUrls);
        videoUrls = SimpleTextHelper.removeInvalidUrls(videoUrls);
        if(audioUrls.isEmpty() && videoUrls.isEmpty())
        {
            log.error("No one valid YouTube URL is provided");
        }
        log.info("Got {} audio URLs and {} video URLs to download", audioUrls.size(),
                videoUrls.size());

        processUrls(audioUrls, ContentType.AUDIO);
        processUrls(videoUrls, ContentType.VIDEO);
    }

    private void processUrls(Set<String> urls, ContentType contentType)
    {
        for(String url : urls)
        {
            List<String> splittedTitle = SimpleTextHelper.splitByWords(youtube.getTitle(url), 70);
            String title;
            if(splittedTitle != null)
            {
                title = splittedTitle.get(0);
            }
            else
            {
                log.error("Failed to get title for {}", url);
                continue;
            }

            // Downloading:
            log.info("Downloading {}", title);
            if(contentType == ContentType.AUDIO)
            {
                youtube.downloadAudio(url);
            }
            else if(contentType == ContentType.VIDEO)
            {
                youtube.downloadVideo(url);
            }

            DownloadState downloadState = youtube.getDownloadState(url);
            while(downloadState != DownloadState.COMPLETE && downloadState != DownloadState.FAIL)
            {
                downloadState = youtube.getDownloadState(url);
                log.debug("Downloading {}, progress: {}", url, youtube.getDownloadProgress(url));
                try
                {
                    Thread.sleep(100);
                }
                catch(InterruptedException e)
                {
                    log.debug("Failed to sleep when getting download state");
                }
            }
            if(downloadState == DownloadState.FAIL)
            {
                log.error("Failed to download {}", title);
                continue;
            }
            YoutubeData youtubeData;
            try
            {
                youtubeData = youtube.getDownloadedData(url);
            }
            catch(YouTubeDownloadException e)
            {
                log.error("Failed to download {}", url);
                continue;
            }
            log.info("Downloaded {}", title);

            // Uploading to Telegram:
            int localFileId;
            log.info("Uploading {} to Telegram", title);
            try
            {
                if(contentType == ContentType.AUDIO)
                {
                    localFileId = telegram.uploadAudio(youtubeData.getFile());
                }
                else if(contentType == ContentType.VIDEO)
                {
                    localFileId = telegram.uploadVideo(youtubeData.getFile());
                }
                else
                {
                    log.error("Provided unknown content type: {}", contentType.toString());
                    continue;
                }
            }
            catch(TelegramUploadFileException e)
            {
                log.error("Failed to upload {} file", youtubeData.getFile().getAbsolutePath());
                continue;
            }
            try
            {
                float progress = telegram.getUploadingProgress(localFileId);
                while(progress <= 99.9f)
                {
                    progress = telegram.getUploadingProgress(localFileId);
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e)
                    {
                        log.error("Failed to sleep when uploading to Telegram");
                    }
                }
            }
            catch(TelegramUploadFileException ex)
            {
                log.error("Failed to upload {} to Telegram", title);
                continue;
            }
            log.info("Uploaded {} to Telegram", title);

            // Sending messages to Telegram:
            String cleanedText = GarbageTextRemover.removeGarbageText(youtubeData.getDescription());
            List<String> description = SimpleTextHelper.splitByWords(cleanedText,
                    TelegramApi.MESSAGE_LENGTH);
            long messageId = 0;

            if(description == null)
            {
                log.error("Failed to prepare description for Telegram");
                continue;
            }
            try
            {
                if(contentType == ContentType.AUDIO)
                {
                    messageId = telegram.sendAudio(localFileId, null,
                            youtubeData.getDurationSeconds(),
                            0);
                }
                else // contentType == ContentType.VIDEO
                {
                    messageId = telegram.sendVideo(localFileId, null,
                            youtubeData.getDurationSeconds(),
                            0);
                }
                for(String descr : description)
                {
                    if(descr.isEmpty())
                    {
                        continue;
                    }
                    messageId = telegram.sendMessage(descr, messageId);
                }
            }
            catch(TelegramSendMessageException ex)
            {
                log.error("Failed to send message to Telegram!");
                log.debug("Previous message ID = {}", messageId);
            }
        }
    }

    @Override
    public void close() throws Exception
    {
        if(telegram != null)
        {
            telegram.close();
        }
        if(youtube != null)
        {
            youtube.close();
        }
    }
}
