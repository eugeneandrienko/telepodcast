package com.eugene_andrienko.telegram.api.exceptions;

public class TelegramInitException extends TelegramException
{
    public TelegramInitException()
    {
        super();
    }

    public TelegramInitException(final String message)
    {
        super(message);
    }

    public TelegramInitException(final Throwable cause)
    {
        super(cause);
    }
}
