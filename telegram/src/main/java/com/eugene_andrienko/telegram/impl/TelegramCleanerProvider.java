package com.eugene_andrienko.telegram.impl;

import java.lang.ref.Cleaner;


/**
 * Cleaner for Telegram library (TDLib).
 */
public class TelegramCleanerProvider
{
    private static final Cleaner CLEANER = Cleaner.create();

    public static Cleaner getCleaner()
    {
        return CLEANER;
    }
}
