package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramAuthException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.impl.Telegram;
import com.eugene_andrienko.telegram.impl.Telegram.MessageSenderState;
import com.eugene_andrienko.telegram.impl.Telegram.MessageType;
import java.io.File;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
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
        Telegram mock = mock(Telegram.class);
        try
        {
            new TelegramApi(mock, 3);
        }
        catch(TelegramAuthException ex)
        {
            fail("Constructor should not throw exception", ex);
        }

        assertThrows(TelegramAuthException.class, () -> new TelegramApi(mock, 0));
        assertThrows(TelegramAuthException.class, () -> new TelegramApi(mock, 3, -1));
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

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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

        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);

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
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
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

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message test")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);

        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(anyLong(), eq(messageType), any()))
                .thenReturn(completableOk);

        File mockedFile = mock(File.class);
        when(mockedFile.getAbsolutePath()).thenReturn("/m/ocked/pat/h");

        try
        {
            CompletableFuture<Boolean> result;
            switch(messageType)
            {
                case TEXT:
                    result = telegramApi.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegramApi.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegramApi.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertTrue(result.get(), "Should get true value after sending message");
        }
        catch(TelegramSendMessageException ex)
        {
            fail("TelegramApi.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message fail test")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageFailTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(anyLong(), eq(messageType), any()))
                .thenReturn(completableFail);

        File mockedFile = mock(File.class);
        when(mockedFile.getAbsolutePath()).thenReturn("/m/ocked/pat/h");

        try
        {
            CompletableFuture<Boolean> result;
            switch(messageType)
            {
                case TEXT:
                    result = telegramApi.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegramApi.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegramApi.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertFalse(result.get(), "Should get false value after sending message with fail");
        }
        catch(TelegramSendMessageException ex)
        {
            fail("TelegramApi.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message retry test")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageRetryTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);

        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(anyLong(), eq(messageType), any()))
                .thenReturn(completableRetry) // First call
                .thenReturn(completableRetry) // First retry
                .thenReturn(completableOk); //   Second retry — should be successful

        File mockedFile = mock(File.class);
        when(mockedFile.getAbsolutePath()).thenReturn("/m/ocked/pat/h");

        try
        {
            CompletableFuture<Boolean> result;
            switch(messageType)
            {
                case TEXT:
                    result = telegramApi.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegramApi.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegramApi.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertTrue(result.get(), "TelegramApi.sendMessage should return true after 1 call " +
                                     "and 2 retries");
            verify(mockedTelegram, times(3)).sendMessage(anyLong(), eq(messageType), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("TelegramApi.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message retry fail test")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageRetryFailTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(anyLong(), eq(messageType), any()))
                .thenReturn(completableRetry) //  First call
                .thenReturn(completableRetry) //  First retry
                .thenReturn(completableRetry); // Second retry — fail

        File mockedFile = mock(File.class);
        when(mockedFile.getAbsolutePath()).thenReturn("/m/ocked/pat/h");

        try
        {
            CompletableFuture<Boolean> result;
            switch(messageType)
            {
                case TEXT:
                    result = telegramApi.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegramApi.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegramApi.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertFalse(result.get(), "TelegramApi.sendMessage should return false after 1 call " +
                                      "and 2 retries");
            verify(mockedTelegram, times(3)).sendMessage(anyLong(), eq(messageType), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("TelegramApi.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message retry complete fail test")
    @SneakyThrows({TelegramAuthException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageRetryCompleteFailTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi telegramApi = new TelegramApi(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(anyLong(), eq(messageType), any()))
                .thenReturn(completableRetry) // First call
                .thenReturn(completableFail); // First retry — fail

        File mockedFile = mock(File.class);
        when(mockedFile.getAbsolutePath()).thenReturn("/m/ocked/pat/h");

        try
        {
            CompletableFuture<Boolean> result;
            switch(messageType)
            {
                case TEXT:
                    result = telegramApi.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegramApi.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegramApi.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertFalse(result.get(), "TelegramApi.sendMessage should return false after 1 call " +
                                      "and 1 retry");
            verify(mockedTelegram, times(2)).sendMessage(anyLong(), eq(messageType), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("TelegramApi.sendMessage() should not throw an exception here");
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
