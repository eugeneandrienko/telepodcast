package com.eugene_andrienko.youtubedl.api;

import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeCannotRunException;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeDownloadException;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoDataException;
import com.eugene_andrienko.youtubedl.impl.AbstractYoutubeDl;
import com.eugene_andrienko.youtubedl.impl.IYoutubeDl;
import com.eugene_andrienko.youtubedl.impl.YoutubeDlGenerator;
import java.io.File;
import java.io.IOException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;


// TODO: download comment with timecodes (if no in video description).

/**
 * API for {@code youtubedl} library - for downloading video and audio from YouTube.
 *
 * Library downloads data from YouTube asynchronously.
 */
@Slf4j
public class YouTubeDlApi implements AutoCloseable
{
    private final IYoutubeDl youtubeDl;

    /**
     * Initializes YouTube downloader.
     *
     * @param countOfThreads Count of threads to download files from YouTube.
     *
     * @throws IOException Failed to initialize YouTube downloader.
     */
    public YouTubeDlApi(int countOfThreads) throws IOException
    {
        youtubeDl = YoutubeDlGenerator.getInstance().generate(countOfThreads);
    }

    /**
     * Initializes YouTube downloader — for test.
     *
     * @param youtubeDl Initialized {@code AbstractYoutubeDl} object.
     */
    YouTubeDlApi(AbstractYoutubeDl youtubeDl)
    {
        this.youtubeDl = youtubeDl;
    }

    /**
     * Checks what YouTube downloader met all requirement to execute.
     *
     * @throws YouTubeCannotRunException Some requirement does not met.
     */
    public void canRun() throws YouTubeCannotRunException
    {
        youtubeDl.canRun();
    }

    /**
     * Asynchronously download audio
     *
     * @param url URL to download
     */
    public void downloadAudio(String url)
    {
        youtubeDl.downloadAudio(url);
    }

    /**
     * Asynchronously download video
     *
     * @param url URL to download
     */
    public void downloadVideo(String url)
    {
        youtubeDl.downloadVideo(url);
    }

    /**
     * Get title of YouTube video from given URL
     *
     * @param url YouTube URL
     *
     * @return Video title or null if no data.
     */
    public String getTitle(String url)
    {
        try
        {
            return youtubeDl.getTitle(url);
        }
        catch(YouTubeNoDataException ex)
        {
            return null;
        }
    }

    /**
     * Get download progress for given URL
     *
     * @param url YouTube URL
     *
     * @return Download progress in percents.
     */
    public float getDownloadProgress(String url)
    {
        return youtubeDl.getDownloadProgress(url);
    }

    /**
     * Get downloading state for given URL
     *
     * @param url YouTube URL
     *
     * @return Download state or {@code DownloadState.NO_DATA} if no data for given URL.
     */
    public DownloadState getDownloadState(String url)
    {
        return youtubeDl.getDownloadState(url);
    }

    /**
     * Get asynchronously downloaded data.
     *
     * @param url YouTube URL
     *
     * @return Initialized {@code YoutubeData}.
     *
     * @throws YouTubeDownloadException No data for given URL.
     */
    public YoutubeData getDownloadedData(String url) throws YouTubeDownloadException
    {
        YoutubeData data = youtubeDl.getDownloadedData(url);
        if(data != null)
        {
            return data;
        }
        else
        {
            log.error("No downloaded data for {} url", url);
            throw new YouTubeDownloadException();
        }
    }

    /**
     * Close library.
     *
     * @throws Exception Failed to close.
     */
    @Override
    public void close() throws Exception
    {
        youtubeDl.close();
    }

    /**
     * Downloading states
     */
    // TODO: i18n this for interface
    public enum DownloadState
    {
        DOWNLOADING, DOWNLOADED, AUDIO_ENCODING, VIDEO_ENCODING, VOLUME_INCREASE, COMPLETE, FAIL,
        NO_DATA
    }

    /**
     * POJO with downloaded from YouTube data
     */
    @AllArgsConstructor
    public static class YoutubeData implements AutoCloseable
    {
        /**
         * Downloaded file
         */
        @Getter
        @NonNull
        private File file;

        /**
         * Description of downloaded file
         */
        @Getter
        private String description;

        public enum ContentType
        {
            AUDIO, VIDEO
        }

        @Getter
        @NonNull
        private ContentType contentType;

        @Getter
        private int durationSeconds;

        /**
         * Deletes the file to free disk space
         *
         * @throws Exception Failed delete file
         */
        @Override
        public void close() throws Exception
        {
            if(!file.delete())
            {
                log.error("Cannot delete {} file!", file.getAbsolutePath());
                throw new IOException("Cannot delete file");
            }
            log.debug("{} deleted", file.getAbsolutePath());
        }
    }
}
