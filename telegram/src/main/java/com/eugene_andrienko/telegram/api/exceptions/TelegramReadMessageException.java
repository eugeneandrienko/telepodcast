package com.eugene_andrienko.telegram.api.exceptions;

public class TelegramReadMessageException extends TelegramException
{
    public TelegramReadMessageException()
    {
        super();
    }

    public TelegramReadMessageException(final String message)
    {
        super(message);
    }

    public TelegramReadMessageException(final Throwable cause)
    {
        super(cause);
    }
}
