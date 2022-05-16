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
    private final int apiId;
    /**
     * Telegram API hash.
     */
    @Getter
    @NonNull
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
     * Enable debug mode
     */
    @Getter
    private final boolean debug;
}
