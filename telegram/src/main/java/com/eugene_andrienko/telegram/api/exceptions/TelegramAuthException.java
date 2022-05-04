package com.eugene_andrienko.telegram.api.exceptions;

/**
 * Something fails in authorization process
 */
public class TelegramAuthException extends TelegramException
{
    public TelegramAuthException()
    {
        super();
    }

    public TelegramAuthException(final String message)
    {
        super(message);
    }

    public TelegramAuthException(final Throwable cause)
    {
        super(cause);
    }
}
