package com.eugene_andrienko.youtubedl.api.exceptions;

public class YouTubeDownloadException extends YouTubeException
{
    public YouTubeDownloadException()
    {
        super();
    }

    public YouTubeDownloadException(final String message)
    {
        super(message);
    }

    public YouTubeDownloadException(final Throwable cause)
    {
        super(cause);
    }
}
