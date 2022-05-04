package com.eugene_andrienko.telegram.api.exceptions;

public abstract class TelegramException extends Exception
{
    public TelegramException()
    {
        super();
    }

    public TelegramException(final String message)
    {
        super(message);
    }

    public TelegramException(final Throwable cause)
    {
        super(cause);
    }
}
