package com.eugene_andrienko.telegram.impl;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
import com.eugene_andrienko.telegram.impl.TelegramTDLibConnector.MessageSenderState;
import com.eugene_andrienko.telegram.impl.TelegramTDLibConnector.MessageType;
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
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.platform.commons.util.ReflectionUtils;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


public class TelegramTest
{
    @Test
    @DisplayName("Test Telegram constructor")
    void constructorTest()
    {
        TelegramTDLibConnector mock = mock(TelegramTDLibConnector.class);
        try
        {
            new Telegram(mock, 3);
        }
        catch(TelegramInitException ex)
        {
            fail("Constructor should not throw exception", ex);
        }

        assertThrows(TelegramInitException.class, () -> new Telegram(mock, 0));
        assertThrows(TelegramInitException.class, () -> new Telegram(mock, 3, -1));
    }

    @Test
    @DisplayName("Test normal behaviour of Telegram login")
    @SneakyThrows(TelegramInitException.class)
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

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableTrue);
        when(mockedTelegram.getSavedMessagesChatName()).thenReturn(completableChatName);
        when(mockedTelegram.getSavedMessagesChatId(FAKE_CHAT_NAME)).thenReturn(completableChatId);

        Telegram telegram = new Telegram(mockedTelegram, 1);
        telegram.login();

        AtomicLong savedMessagesId = Objects.requireNonNull(getChatIdField(telegram));
        assertEquals(savedMessagesId.get(), FAKE_CHAT_ID, "Non expected chat ID");
    }

    @Test
    @DisplayName("Test init fail during login")
    @SneakyThrows(TelegramInitException.class)
    void loginInitFailTest()
    {
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        when(mockedTelegram.init()).thenReturn(completableFalse);

        Telegram telegram = new Telegram(mockedTelegram, 1);
        telegram.login();
        assertFalse(telegram.isReady().isDone(), "Login should not complete");
    }

    @Test
    @DisplayName("Test init exception during login")
    @SneakyThrows(TelegramInitException.class)
    void loginInitExceptionTest()
    {
        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        when(mockedTelegram.init()).thenThrow(TelegramInitException.class);

        Telegram telegram = new Telegram(mockedTelegram, 1);
        try
        {
            telegram.login();
            fail("TelegramInitException should be thrown");
        }
        catch(TelegramInitException e)
        {
            // Test passed
        }
    }

    @Test
    @DisplayName("Test load  chats fail during login")
    @SneakyThrows(TelegramInitException.class)
    void loginLoadChatsFailTest()
    {
        CompletableFuture<Boolean> completableTrue = new CompletableFuture<>();
        completableTrue.complete(true);
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableFalse);

        Telegram telegram = new Telegram(mockedTelegram, 1);
        telegram.login();
        assertFalse(telegram.isReady().isDone(), "Login should not complete");
    }

    @Test
    @DisplayName("Test getting chat name fail during login")
    @SneakyThrows(TelegramInitException.class)
    void loginGetChatNameFailTest()
    {
        CompletableFuture<Boolean> completableTrue = new CompletableFuture<>();
        completableTrue.complete(true);
        CompletableFuture<Boolean> completableFalse = new CompletableFuture<>();
        completableFalse.complete(false);

        CompletableFuture<String> completableChatName = new CompletableFuture<>();

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableTrue);
        when(mockedTelegram.getSavedMessagesChatName()).thenReturn(completableChatName);

        Telegram telegram = new Telegram(mockedTelegram, 1);
        telegram.login();
        assertFalse(telegram.isReady().isDone(), "Login should not complete");
    }

    @Test
    @DisplayName("Test getting chat ID fail during login")
    @SneakyThrows({TelegramInitException.class,
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

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        when(mockedTelegram.init()).thenReturn(completableTrue);
        doNothing().when(mockedTelegram).loadChatList(anyInt());
        when(mockedTelegram.isChatListLoaded(anyInt())).thenReturn(completableTrue);
        when(mockedTelegram.getSavedMessagesChatName()).thenReturn(completableChatName);
        when(mockedTelegram.getSavedMessagesChatId(FAKE_CHAT_NAME)).thenReturn(completableChatId);

        Telegram telegram = new Telegram(mockedTelegram, 1);
        telegram.login();
        try
        {
            telegram.isReady().get(1, TimeUnit.NANOSECONDS);
            fail("Login should not complete");
        }
        catch(TimeoutException ex)
        {
            // Test succeed!
        }
    }

    @Test
    @DisplayName("isReady() - ok")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isReadyOkTest()
    {
        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        AtomicLong savedMessagesId = Objects.requireNonNull(getChatIdField(telegram));
        savedMessagesId.set(12);


        assertTrue(telegram.isReady().get(),
                "Telegram.isReady() should return true if API is ready");
    }

    @Test
    @DisplayName("isReady() fail test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isReadyFailTest()
    {
        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);

        try
        {
            telegram.isReady().get(1, TimeUnit.NANOSECONDS);
            fail("isReady() returns successfully when Telegram init not completed");
        }
        catch(TimeoutException ex)
        {
            // Test passed
        }
    }

    @Test
    @DisplayName("Close test")
    @SneakyThrows(TelegramInitException.class)
    void closeTest()
    {
        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        try
        {
            telegram.close();
        }
        catch(Exception ex)
        {
            fail("Telegram close should not issue an exception", ex);
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

    @Test
    @DisplayName("Upload audio test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void uploadAudioTest()
    {
        CompletableFuture<Integer> forTest = new CompletableFuture<>();
        forTest.complete(1);
        File mockedFile = mock(File.class);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.uploadFile(any(File.class), eq(MessageType.AUDIO))).thenReturn(forTest);

        CompletableFuture<Integer> result = telegram.uploadAudio(mockedFile);
        assertEquals(1, result.get(), "Result should be equal to 1");
    }

    @Test
    @DisplayName("Upload video test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void uploadVideoTest()
    {
        CompletableFuture<Integer> forTest = new CompletableFuture<>();
        forTest.complete(1);
        File mockedFile = mock(File.class);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.uploadFile(any(File.class), eq(MessageType.VIDEO))).thenReturn(forTest);

        CompletableFuture<Integer> result = telegram.uploadVideo(mockedFile);
        assertEquals(1, result.get(), "Result should be equal to 1");
    }

    @Test
    @DisplayName("Get uploading progress test")
    @SneakyThrows({TelegramInitException.class, TelegramUploadFileException.class})
    void getUploadingProgressTest()
    {
        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.getUploadFileProgress(anyInt())).thenReturn(42.42f);

        float result = telegram.getUploadingProgress(2);
        assertEquals(42.42f, result, "Expected and actual upload file progress differs");
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageTest(MessageType messageType)
    {
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableOk =
                new CompletableFuture<>();
        completableOk.complete(ImmutablePair.of(MessageSenderState.OK, 42L));

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(
                anyLong(), eq(messageType), any(), anyLong(), any())).thenReturn(completableOk);

        try
        {
            CompletableFuture<ImmutablePair<Boolean, Long>> result;
            switch(messageType)
            {
                case TEXT -> result = telegram.sendMessage("TEST MSG", 0L);
                case AUDIO -> result = telegram.sendAudio(123, "TEST", 1, 0L);
                case VIDEO -> result = telegram.sendVideo(456, "TEST", 1, 0L);
                default ->
                {
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
                }
            }
            assertTrue(result.get().getLeft(), "Should get true value after sending message");
            assertEquals(42L, result.get().getRight(), "Should get ID = 42L after sending " +
                                                       "message");
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message fail test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageFailTest(MessageType messageType)
    {
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableFail =
                new CompletableFuture<>();
        completableFail.complete(ImmutablePair.of(MessageSenderState.FAIL, 42L));

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(
                anyLong(), eq(messageType), any(), anyLong(), any()))
                .thenReturn(completableFail);

        try
        {
            CompletableFuture<ImmutablePair<Boolean, Long>> result;
            switch(messageType)
            {
                case TEXT -> result = telegram.sendMessage("TEST MSG", 0L);
                case AUDIO -> result = telegram.sendAudio(123, "TEST", 1, 0L);
                case VIDEO -> result = telegram.sendVideo(456, "TEST", 1, 0L);
                default ->
                {
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
                }
            }
            assertFalse(result.get().getLeft(), "Should get false value after sending message " +
                                                "with fail");
            assertEquals(42L, result.get().getRight(), "Should get ID = 42L after sending " +
                                                       "message with fail");
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message retry test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageRetryTest(MessageType messageType)
    {
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableRetry =
                new CompletableFuture<>();
        completableRetry.complete(ImmutablePair.of(MessageSenderState.RETRY, 42L));
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableOk =
                new CompletableFuture<>();
        completableOk.complete(ImmutablePair.of(MessageSenderState.OK, 43L));

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(
                anyLong(), eq(messageType), any(), anyLong(), any()))
                .thenReturn(completableRetry) // First call
                .thenReturn(completableRetry) // First retry
                .thenReturn(completableOk); //   Second retry — should successful

        try
        {
            CompletableFuture<ImmutablePair<Boolean, Long>> result;
            switch(messageType)
            {
                case TEXT -> result = telegram.sendMessage("TEST MSG", 0L);
                case AUDIO -> result = telegram.sendAudio(123, "TEST", 1, 0L);
                case VIDEO -> result = telegram.sendVideo(456, "TEST", 1, 0L);
                default ->
                {
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
                }
            }
            assertTrue(result.get().getLeft(), "Telegram.sendMessage should return true after " +
                                               "1 call and 2 retries");
            assertEquals(43L, result.get().getRight(), "Telegram.sendMessage should return ID = " +
                                                       "43L after 1 call and 2 retries");
            verify(mockedTelegram, times(3)).sendMessage(anyLong(), eq(messageType), any(),
                    anyLong(), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message retry fail test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageRetryFailTest(MessageType messageType)
    {
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableRetry =
                new CompletableFuture<>();
        completableRetry.complete(ImmutablePair.of(MessageSenderState.RETRY, 42L));
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableFail =
                new CompletableFuture<>();
        completableFail.complete(ImmutablePair.of(MessageSenderState.FAIL, 43L));

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(
                anyLong(), eq(messageType), any(), anyLong(), any()))
                .thenReturn(completableRetry) //  First call
                .thenReturn(completableRetry) //  First retry
                .thenReturn(completableRetry); // Second retry — fail

        try
        {
            CompletableFuture<ImmutablePair<Boolean, Long>> result;
            switch(messageType)
            {
                case TEXT -> result = telegram.sendMessage("TEST MSG", 0L);
                case AUDIO -> result = telegram.sendAudio(123, "TEST", 1, 0L);
                case VIDEO -> result = telegram.sendVideo(456, "TEST", 1, 0L);
                default ->
                {
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
                }
            }
            assertFalse(result.get().getLeft(), "Telegram.sendMessage should return false after " +
                                                "1 call and 2 retries");
            verify(mockedTelegram, times(3)).sendMessage(anyLong(), eq(messageType), any(),
                    anyLong(), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message retry complete fail test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageRetryCompleteFailTest(MessageType messageType)
    {
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableRetry =
                new CompletableFuture<>();
        completableRetry.complete(ImmutablePair.of(MessageSenderState.RETRY, 0L));
        CompletableFuture<ImmutablePair<MessageSenderState, Long>> completableFail =
                new CompletableFuture<>();
        completableFail.complete(ImmutablePair.of(MessageSenderState.FAIL, 0L));

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
        when(mockedTelegram.sendMessage(
                anyLong(), eq(messageType), any(), anyLong(), any()))
                .thenReturn(completableRetry) // First call
                .thenReturn(completableFail); // First retry — fail

        try
        {
            CompletableFuture<ImmutablePair<Boolean, Long>> result;
            switch(messageType)
            {
                case TEXT -> result = telegram.sendMessage("TEST MSG", 0L);
                case AUDIO -> result = telegram.sendAudio(123, "TEST", 1, 0L);
                case VIDEO -> result = telegram.sendVideo(456, "TEST", 1, 0L);
                default ->
                {
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
                }
            }
            assertFalse(result.get().getLeft(), "Telegram.sendMessage should return false after " +
                                                "1 call and 1 retry");
            verify(mockedTelegram, times(2)).sendMessage(anyLong(), eq(messageType), any(),
                    anyLong(), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message null test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageNullTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);

        try
        {
            CompletableFuture<ImmutablePair<Boolean, Long>> result;
            switch(messageType)
            {
                case TEXT -> result = telegram.sendMessage(null, 0L);
                case AUDIO -> result = telegram.sendAudio(null, "TEST", 1, 0L);
                case VIDEO -> result = telegram.sendVideo(null, "TEST", 1, 0L);
                default ->
                {
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
                }
            }
            assertFalse(result.get().getLeft(), "Telegram.sendMessage should return false");
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }


    /**
     * Retrieves {@code Telegram.savedMessagesId} private field via reflection.
     *
     * @param telegram Initialized {@code Telegram} object.
     *
     * @return Initialized {@code Telegram.savedMessagesId} field.
     */
    private AtomicLong getChatIdField(Object telegram)
    {
        final String SAVED_MESSAGES_ID_FIELD = "savedMessagesId";

        List<Field> savedMessagesIdField = ReflectionUtils.findFields(Telegram.class,
                (field) -> SAVED_MESSAGES_ID_FIELD.equals(field.getName()),
                ReflectionUtils.HierarchyTraversalMode.TOP_DOWN);
        assumeTrue(savedMessagesIdField.size() == 1, String.format(
                "Should be only one %s field", SAVED_MESSAGES_ID_FIELD));
        savedMessagesIdField.get(0).setAccessible(true);
        Object savedMessagesId = null;
        try
        {
            savedMessagesId = savedMessagesIdField.get(0).get(telegram);
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
            // For the compiler. Next line never executed:
            return null;
        }
    }
}
