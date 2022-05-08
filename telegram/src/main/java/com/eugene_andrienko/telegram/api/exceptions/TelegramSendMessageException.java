package com.eugene_andrienko.telegram.api.exceptions;

public class TelegramSendMessageException extends TelegramException
{
    public TelegramSendMessageException()
    {
        super();
    }

    public TelegramSendMessageException(final String message)
    {
        super(message);
    }

    public TelegramSendMessageException(final Throwable cause)
    {
        super(cause);
    }
}
