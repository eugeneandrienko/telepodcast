package com.eugene_andrienko.telegram.api.exceptions;

/**
 * Cannot find "Saved Messages" chat.
 */
public class TelegramChatNotFoundException extends TelegramException
{
    public TelegramChatNotFoundException()
    {
        super();
    }

    public TelegramChatNotFoundException(final String message)
    {
        super(message);
    }

    public TelegramChatNotFoundException(final Throwable cause)
    {
        super(cause);
    }
}
