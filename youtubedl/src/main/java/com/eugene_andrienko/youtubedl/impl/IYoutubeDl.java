package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoTitleException;


public interface IYoutubeDl
{
    void downloadAudio(String url);
    void downloadVideo(String url);
    String getTitle(String url) throws YouTubeNoTitleException;

    float getDownloadProgress(String url);
    DownloadState getDownloadState(String url);
    YoutubeData getDownloadedData(String url);

    void close() throws Exception;
}
