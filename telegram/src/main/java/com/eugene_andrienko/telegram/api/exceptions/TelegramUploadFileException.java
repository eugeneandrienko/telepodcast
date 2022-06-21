package com.eugene_andrienko.telegram.api.exceptions;

public class TelegramUploadFileException extends TelegramException
{
    public TelegramUploadFileException()
    {
        super();
    }

    public TelegramUploadFileException(final String message)
    {
        super(message);
    }

    public TelegramUploadFileException(final Throwable cause)
    {
        super(cause);
    }
}
