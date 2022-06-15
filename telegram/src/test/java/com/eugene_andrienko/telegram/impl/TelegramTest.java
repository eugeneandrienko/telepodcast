package com.eugene_andrienko.telegram.impl;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
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
import org.drinkless.tdlib.TdApi;
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

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Send message test")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void sendMessageTest(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
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
                    result = telegram.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegram.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegram.sendVideo(mockedFile);
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
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
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
                    result = telegram.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegram.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegram.sendVideo(mockedFile);
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
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
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
                    result = telegram.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegram.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegram.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertTrue(result.get(), "Telegram.sendMessage should return true after 1 call " +
                                     "and 2 retries");
            verify(mockedTelegram, times(3)).sendMessage(anyLong(), eq(messageType), any());
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
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
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
                    result = telegram.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegram.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegram.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertFalse(result.get(), "Telegram.sendMessage should return false after 1 call " +
                                      "and 2 retries");
            verify(mockedTelegram, times(3)).sendMessage(anyLong(), eq(messageType), any());
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
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableFail = new CompletableFuture<>();
        completableFail.complete(MessageSenderState.FAIL);

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);
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
                    result = telegram.sendMessage("TEST MSG");
                    break;
                case AUDIO:
                    result = telegram.sendAudio(mockedFile);
                    break;
                case VIDEO:
                    result = telegram.sendVideo(mockedFile);
                    break;
                default:
                    fail("Unknown MessageType");
                    // For the compiler; we fail in previous line:
                    return;
            }
            assertFalse(result.get(), "Telegram.sendMessage should return false after 1 call " +
                                      "and 1 retry");
            verify(mockedTelegram, times(2)).sendMessage(anyLong(), eq(messageType), any());
        }
        catch(TelegramSendMessageException ex)
        {
            fail("Telegram.sendMessage() should not throw an exception here");
        }
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Test is Telegram message in chat")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isMessageInChat(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);

        TdApi.Message[] message;
        TdApi.Messages messages;
        CompletableFuture<TdApi.Messages> completableMessages;

        final String TEST_MSG = "TEST MSG";
        final String TEST_NAME = "mocked.name";

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);

        File mockedFile = mock(File.class);
        when(mockedFile.getName()).thenReturn(TEST_NAME);

        CompletableFuture<Boolean> result;
        switch(messageType)
        {
            case TEXT:
                TdApi.MessageText content = new TdApi.MessageText();
                content.text = new TdApi.FormattedText(TEST_MSG, null);

                message = new TdApi.Message[1];
                message[0] = new TdApi.Message();
                message[0].content = content;

                messages = new TdApi.Messages(1, message);
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(messages);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);

                result = telegram.isMessageInChat(TEST_MSG);
                break;
            case AUDIO:
                TdApi.MessageAudio audio = new TdApi.MessageAudio();
                audio.audio = new TdApi.Audio();
                audio.audio.fileName = TEST_NAME;

                message = new TdApi.Message[1];
                message[0] = new TdApi.Message();
                message[0].content = audio;

                messages = new TdApi.Messages(1, message);
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(messages);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);
                result = telegram.isAudioInChat(mockedFile);
                break;
            case VIDEO:
                TdApi.MessageVideo video = new TdApi.MessageVideo();
                video.video = new TdApi.Video();
                video.video.fileName = TEST_NAME;

                message = new TdApi.Message[1];
                message[0] = new TdApi.Message();
                message[0].content = video;

                messages = new TdApi.Messages(1, message);
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(messages);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);
                result = telegram.isVideoInChat(mockedFile);
                break;
            default:
                fail("Unknown MessageType");
                // For the compiler; we fail in previous line:
                return;
        }
        assertTrue(result.get(), "Telegram.isXXXInChat should return true");
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Test is Telegram message in chat - no messages")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isMessageInChatNoMessages(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);
        CompletableFuture<TdApi.Messages> completableMessages;

        final String TEST_MSG = "TEST MSG";
        final String TEST_NAME = "mocked.name";

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);

        File mockedFile = mock(File.class);
        when(mockedFile.getName()).thenReturn(TEST_NAME);

        CompletableFuture<Boolean> result;
        switch(messageType)
        {
            case TEXT:
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(null);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);

                result = telegram.isMessageInChat(TEST_MSG);
                break;
            case AUDIO:
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(null);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);
                result = telegram.isAudioInChat(mockedFile);
                break;
            case VIDEO:
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(null);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);
                result = telegram.isVideoInChat(mockedFile);
                break;
            default:
                fail("Unknown MessageType");
                // For the compiler; we fail in previous line:
                return;
        }
        assertFalse(result.get(), "Telegram.isXXXInChat should return false");
    }

    @ParameterizedTest
    @EnumSource(MessageType.class)
    @DisplayName("Test is Telegram message in chat - but not exists")
    @SneakyThrows({TelegramInitException.class,
                   InterruptedException.class,
                   ExecutionException.class})
    void isMessageInChatNoMessageInChat(MessageType messageType)
    {
        CompletableFuture<MessageSenderState> completableRetry = new CompletableFuture<>();
        completableRetry.complete(MessageSenderState.RETRY);
        CompletableFuture<MessageSenderState> completableOk = new CompletableFuture<>();
        completableOk.complete(MessageSenderState.OK);

        TdApi.Message[] message;
        TdApi.Messages messages;
        CompletableFuture<TdApi.Messages> completableMessages;

        final String TEST_MSG = "TEST MSG";
        final String TEST_NAME = "mocked.name";

        TelegramTDLibConnector mockedTelegram = mock(TelegramTDLibConnector.class);
        Telegram telegram = new Telegram(mockedTelegram, 1);

        File mockedFile = mock(File.class);
        when(mockedFile.getName()).thenReturn(TEST_NAME);

        CompletableFuture<Boolean> result;
        switch(messageType)
        {
            case TEXT:
                TdApi.MessageText content = new TdApi.MessageText();
                content.text = new TdApi.FormattedText(TEST_MSG, null);

                message = new TdApi.Message[1];
                message[0] = new TdApi.Message();
                message[0].content = content;

                messages = new TdApi.Messages(1, message);
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(messages);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);

                result = telegram.isMessageInChat(TEST_MSG + "FAIL");
                break;
            case AUDIO:
                TdApi.MessageAudio audio = new TdApi.MessageAudio();
                audio.audio = new TdApi.Audio();
                audio.audio.fileName = TEST_NAME + "FAIL";

                message = new TdApi.Message[1];
                message[0] = new TdApi.Message();
                message[0].content = audio;

                messages = new TdApi.Messages(1, message);
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(messages);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);
                result = telegram.isAudioInChat(mockedFile);
                break;
            case VIDEO:
                TdApi.MessageVideo video = new TdApi.MessageVideo();
                video.video = new TdApi.Video();
                video.video.fileName = TEST_NAME + "FAIL";

                message = new TdApi.Message[1];
                message[0] = new TdApi.Message();
                message[0].content = video;

                messages = new TdApi.Messages(1, message);
                completableMessages = new CompletableFuture<>();
                completableMessages.complete(messages);

                when(mockedTelegram.getMessages(anyLong(), anyInt()))
                        .thenReturn(completableMessages);
                result = telegram.isVideoInChat(mockedFile);
                break;
            default:
                fail("Unknown MessageType");
                // For the compiler; we fail in previous line:
                return;
        }
        assertFalse(result.get(), "Telegram.isXXXInChat should return false");
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
            // For the compiler. Next line never be executed:
            return null;
        }
    }
}
