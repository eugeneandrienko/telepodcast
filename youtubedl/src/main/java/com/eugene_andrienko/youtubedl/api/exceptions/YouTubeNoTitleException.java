package com.eugene_andrienko.youtubedl.api.exceptions;

public class YouTubeNoTitleException extends YouTubeException
{
    public YouTubeNoTitleException()
    {
        super();
    }

    public YouTubeNoTitleException(final String message)
    {
        super(message);
    }

    public YouTubeNoTitleException(final Throwable cause)
    {
        super(cause);
    }
}
