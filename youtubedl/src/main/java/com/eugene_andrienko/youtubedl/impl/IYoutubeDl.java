package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeCannotRunException;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoDataException;


public interface IYoutubeDl
{
    /**
     * Downloads only audio from YouTube video in background.
     *
     * @param url URL to YouTube video
     */
    void downloadAudio(String url);

    /**
     * Downloads video from YouTube in background.
     *
     * @param url URL to YouTube video
     */
    void downloadVideo(String url);

    /**
     * Returns title of YouTube video.
     *
     * Works synchronously.
     *
     * @param url URL to YouTube video
     *
     * @return Video title
     *
     * @throws YouTubeNoDataException Fail to get title from YouTube
     */
    String getTitle(String url) throws YouTubeNoDataException;

    /**
     * Returns download progress in percents.
     *
     * @param url URL to YouTube video
     *
     * @return Download progress in percents
     */
    float getDownloadProgress(String url);

    /**
     * Returns downloading state.
     *
     * See {@link com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState} for details.
     *
     * @param url URL to YouTube video
     *
     * @return Downloading state as {@link com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState}
     */
    DownloadState getDownloadState(String url);

    /**
     * Returns downloaded data (if exists).
     *
     * @param url URL to YouTube video
     *
     * @return Downloaded data as
     * {@link com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData} or null.
     */
    YoutubeData getDownloadedData(String url);

    /**
     * Check what selected realization of this interface can be executed.
     *
     * @throws YouTubeCannotRunException Selected realization cannot be executed.
     */
    void canRun() throws YouTubeCannotRunException;

    void close() throws Exception;
}
