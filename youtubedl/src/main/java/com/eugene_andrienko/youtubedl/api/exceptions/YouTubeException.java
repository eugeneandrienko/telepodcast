package com.eugene_andrienko.youtubedl.api.exceptions;

public abstract class YouTubeException extends Exception
{
    public YouTubeException()
    {
        super();
    }

    public YouTubeException(final String message)
    {
        super(message);
    }

    public YouTubeException(final Throwable cause)
    {
        super(cause);
    }
}
