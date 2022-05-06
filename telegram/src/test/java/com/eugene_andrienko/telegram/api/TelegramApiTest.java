package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramAuthException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class TelegramApiTest
{
    @Test
    @DisplayName("Test TelegramApi constructor")
    void constructorTest()
    {
        try
        {
            new TelegramApi(1, "2", 3, true);
            new TelegramApi(1, "2", 3, false);
        }
        catch(TelegramAuthException ex)
        {
            fail("Constructor should not throw exception", ex);
        }

        assertThrows(TelegramAuthException.class, () -> new TelegramApi(0, "2", 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, null, 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, "", 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, " ", 3, true));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(1, "2", 0, true));
    }

    @Test
    @DisplayName("Test normal behaviour of Telegram login")
    @SneakyThrows(TelegramAuthException.class)
    void loginNormalTest()
    {
        CompletableFuture<Boolean> completableTrue = new CompletableFuture<>();
        completableTrue.complete(true);
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        final String FAKE_CHAT_NAME = "Fake chat name";
        CompletableFuture<String> completableChatName = new CompletableFuture<>();
        completableChatName.complete(FAKE_CHAT_NAME);

        final long FAKE_CHAT_ID = 1;
        CompletableFuture<Long> completableChatId = new CompletableFuture<>();
        completableChatId.complete(FAKE_CHAT_ID);

        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableTrue);
        when(mockedTelegram.getSavedMessagesChatName()).thenReturn(completableChatName);
        when(mockedTelegram.getSavedMessagesChatId(FAKE_CHAT_NAME)).thenReturn(completableChatId);

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        telegramApi.login();

        AtomicLong savedMessagesId = Objects.requireNonNull(getChatIdField(telegramApi));
        assertEquals(savedMessagesId.get(), FAKE_CHAT_ID, "Non expected chat ID");
    }

    @Test
    @DisplayName("Test init fail during login")
    @SneakyThrows(TelegramAuthException.class)
    void loginInitFailTest()
    {
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.init()).thenReturn(completableFalse);

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        telegramApi.login();
        assertFalse(telegramApi.isReady().isDone(), "Login should not complete");
    }

    @Test
    @DisplayName("Test load  chats fail during login")
    @SneakyThrows(TelegramAuthException.class)
    void loginLoadChatsFailTest()
    {
        CompletableFuture<Boolean> completableTrue = new CompletableFuture<>();
        completableTrue.complete(true);
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableFalse);

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        telegramApi.login();
        assertFalse(telegramApi.isReady().isDone(), "Login should not complete");
    }

    @Test
    @DisplayName("Test getting chat name fail during login")
    @SneakyThrows(TelegramAuthException.class)
    void loginGetChatNameFailTest()
    {
        CompletableFuture<Boolean> completableTrue = new CompletableFuture<>();
        completableTrue.complete(true);
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        CompletableFuture<String> completableChatName = new CompletableFuture<>();

        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableTrue);
        when(mockedTelegram.getSavedMessagesChatName()).thenReturn(completableChatName);

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        telegramApi.login();
        assertFalse(telegramApi.isReady().isDone(), "Login should not complete");
    }

    @Test
    @DisplayName("Test getting chat ID fail during login")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void loginGetChatIdFailTest()
    {
        CompletableFuture<Boolean> completableTrue = new CompletableFuture<>();
        completableTrue.complete(true);
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        final String FAKE_CHAT_NAME = "Fake chat name";
        CompletableFuture<String> completableChatName = new CompletableFuture<>();
        completableChatName.complete(FAKE_CHAT_NAME);

        CompletableFuture<Long> completableChatId = new CompletableFuture<>();

        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableTrue);
        when(mockedTelegram.getSavedMessagesChatName()).thenReturn(completableChatName);
        when(mockedTelegram.getSavedMessagesChatId(FAKE_CHAT_NAME)).thenReturn(completableChatId);

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        telegramApi.login();
        try
        {
            telegramApi.isReady().get(1, TimeUnit.NANOSECONDS);
            fail("Login should not complete");
        }
        catch(TimeoutException ex)
        {
            // Test succeed!
        }
    }

    @Test
    @DisplayName("isReady() - ok")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isReadyOkTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        AtomicLong savedMessagesId = Objects.requireNonNull(getChatIdField(telegramApi));
        savedMessagesId.set(12);


        assertTrue(telegramApi.isReady().get(),
                "TelegramApi.isReady() should return true if API is ready");
    }

    @Test
    @DisplayName("isReady() fail test")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isReadyFailTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);

        try
        {
            telegramApi.isReady().get(1, TimeUnit.NANOSECONDS);
            fail("isReady() returns successfully when Telegram init not completed");
        }
        catch(TimeoutException ex)
        {
            // Test passed
        }
    }

    @Test
    @DisplayName("Close test")
    @SneakyThrows(TelegramAuthException.class)
    void closeTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1, true);
        try
        {
            telegramApi.close();
        }
        catch(Exception ex)
        {
            fail("TelegramApi close should not issue an exception", ex);
        }
        try
        {
            verify(mockedTelegram, times(1)).close();
        }
        catch(Exception ex)
        {
            fail("Got an exception when checks Telegram.close() count of calls", ex);
        }
    }


    /**
     * Retrieves {@code TelegramApi.savedMessagesId} private field via reflection.
     *
     * @param telegramApi Initialized {@code TelegramApi} object.
     *
     * @return Initialized {@code TelegramApi.savedMessagesId} field.
     */
    private AtomicLong getChatIdField(Object telegramApi)
    {
        final String SAVED_MESSAGES_ID_FIELD = "savedMessagesId";

        List<Field> savedMessagesIdField = ReflectionUtils.findFields(TelegramApi.class,
                (field) -> SAVED_MESSAGES_ID_FIELD.equals(field.getName()),
                ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
        assumeTrue(savedMessagesIdField.size() == 1, String.format(
                "Should be only one %s field", SAVED_MESSAGES_ID_FIELD));
        savedMessagesIdField.get(0).setAccessible(true);
        Object savedMessagesId = null;
        try
        {
            savedMessagesId = savedMessagesIdField.get(0).get(telegramApi);
        }
        catch(IllegalAccessException e)
        {
            fail(String.format("Could not get access to %s", SAVED_MESSAGES_ID_FIELD));
        }
        if(savedMessagesId instanceof AtomicLong)
        {
            return (AtomicLong)savedMessagesId;
        }
        else
        {
            fail(String.format("%s is not an AtomicLong", SAVED_MESSAGES_ID_FIELD));
            // For the compiler. Next line never be executed:
            return null;
        }
    }
}
