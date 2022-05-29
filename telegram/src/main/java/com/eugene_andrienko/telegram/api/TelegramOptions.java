package com.eugene_andrienko.telegram.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;


@ToString
@AllArgsConstructor
public class TelegramOptions
{
    /**
     * Telegram API ID.
     */
    @Getter
    @ToString.Exclude
    private final int apiId;

    /**
     * Telegram API hash.
     */
    @Getter
    @NonNull
    @ToString.Exclude
    private final String apiHash;

    /**
     * Count of chats from chat list, where to search "Saved Messages" chat.
     */
    @Getter
    private final int loadingChatsLimit;

    /**
     * Count of resend retries, when sending message fails
     */
    @Getter
    private final int resendRetries;

    /**
     * Delay in seconds to complete any library call.
     */
    @Getter
    private final int delaySeconds;

    /**
     * Path to TDLib debug log file
     */
    @Getter
    @NonNull
    private final String tdlibLog;

    /**
     * Path to TDLib data directory
     */
    @Getter
    @NonNull
    private final String tdlibDir;

    /**
     * Enable debug mode
     */
    @Getter
    private final boolean debug;
}
