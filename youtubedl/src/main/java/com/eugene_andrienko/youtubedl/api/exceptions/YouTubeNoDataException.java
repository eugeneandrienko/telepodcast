package com.eugene_andrienko.youtubedl.api.exceptions;

public class YouTubeNoDataException extends YouTubeException
{
    public YouTubeNoDataException()
    {
        super();
    }

    public YouTubeNoDataException(final String message)
    {
        super(message);
    }

    public YouTubeNoDataException(final Throwable cause)
    {
        super(cause);
    }
}
