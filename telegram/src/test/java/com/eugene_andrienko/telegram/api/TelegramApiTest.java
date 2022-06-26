package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import org.javatuples.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class TelegramApiTest
{
    @Test
    @DisplayName("Init test")
    void initTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);
        // Should not throw any exceptions here
    }

    @Test
    @DisplayName("Login test")
    @SneakyThrows(TelegramInitException.class)
    void loginTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        doNothing().when(mockedTelegram).login();
        when(mockedTelegram.isReady()).thenReturn(completableTrue)
                                      .thenReturn(completableFalse)
                                      .thenReturn(completableNeverBoolean);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.login();
        assertThrows(TelegramInitException.class, forTest::login);
        assertThrows(TelegramInitException.class, forTest::login);
    }

    @Test
    @DisplayName("Send message test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendMessageTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendMessage(anyString(), anyLong())).thenReturn(completableTruePair)
                                                                .thenReturn(completableFalsePair)
                                                                .thenReturn(completableNeverPair)
                                                                .thenReturn(completableTruePair);
        when(mockedTelegram.getServerMessageId(0L)).thenReturn(completableLong)
                                                   .thenReturn(completableNeverLong);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        long result = forTest.sendMessage("TEST", 0L);
        assertEquals(MOCKED_ID, result, "Should return mocked ID");
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage(null, 0L));
        assertThrows(TelegramSendMessageException.class,
                () -> forTest.sendMessage("x".repeat(TelegramApi.MESSAGE_LENGTH + 1), 0L));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST", 0L));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST", 0L));
        result = forTest.sendMessage("TEST", 0L);
        assertEquals(0L, result, "Should return zero ID");
    }

    @Test
    @DisplayName("Upload audio test")
    @SneakyThrows(TelegramUploadFileException.class)
    void uploadAudioTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.uploadAudio(any(File.class))).thenReturn(completableInteger)
                                                         .thenReturn(completableNeverInteger);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);
        File mockedFile = mock(File.class);

        int result = forTest.uploadAudio(mockedFile);
        assertEquals(MOCKED_ID, result, "File ID is not equals with expected");
        assertThrows(TelegramUploadFileException.class, () -> forTest.uploadAudio(mockedFile));
    }

    @Test
    @DisplayName("Send audio test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendAudioTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendAudio(anyInt(), anyString(), anyLong()))
                .thenReturn(completableTruePair)
                .thenReturn(completableFalsePair)
                .thenReturn(completableNeverPair)
                .thenReturn(completableTruePair);
        when(mockedTelegram.getServerMessageId(0L)).thenReturn(completableLong)
                                                   .thenReturn(completableNeverLong);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        long result = forTest.sendAudio(123, "TEST", 0L);
        assertEquals(MOCKED_ID, result, "Should return mocked ID");
        assertThrows(TelegramSendMessageException.class,
                () -> forTest.sendAudio(123, "x".repeat(TelegramApi.MEDIA_CAPTION_LENGTH + 1), 0L));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(123, "TEST", 0L));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(123, "TEST", 0L));
        result = forTest.sendAudio(123, "TEST", 0L);
        assertEquals(0L, result, "Should return zero ID");
    }

    @Test
    @DisplayName("Upload video test")
    @SneakyThrows(TelegramUploadFileException.class)
    void uploadVideoTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.uploadVideo(any(File.class))).thenReturn(completableInteger)
                                                         .thenReturn(completableNeverInteger);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);
        File mockedFile = mock(File.class);

        int result = forTest.uploadVideo(mockedFile);
        assertEquals(MOCKED_ID, result, "File ID is not equals with expected");
        assertThrows(TelegramUploadFileException.class, () -> forTest.uploadVideo(mockedFile));
    }

    @Test
    @DisplayName("Send video test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendVideoTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendVideo(anyInt(), anyString(), anyLong()))
                .thenReturn(completableTruePair)
                .thenReturn(completableFalsePair)
                .thenReturn(completableNeverPair)
                .thenReturn(completableTruePair);
        when(mockedTelegram.getServerMessageId(0L)).thenReturn(completableLong)
                                                   .thenReturn(completableNeverLong);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        long result = forTest.sendVideo(123, "TEST", 0L);
        assertEquals(MOCKED_ID, result, "Should return mocked ID");
        assertThrows(TelegramSendMessageException.class,
                () -> forTest.sendVideo(123, "x".repeat(TelegramApi.MEDIA_CAPTION_LENGTH + 1), 0L));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(123, "TEST", 0L));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(123, "TEST", 0L));
        result = forTest.sendVideo(123, "TEST", 0L);
        assertEquals(0L, result, "Should return zero ID");
    }

    @Test
    @DisplayName("Get uploading progress test")
    @SneakyThrows(TelegramUploadFileException.class)
    void getUploadingProgressTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.getUploadingProgress(anyInt()))
                .thenReturn(99.99f)
                .thenThrow(TelegramUploadFileException.class);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        float result = forTest.getUploadingProgress(22);
        assertEquals(99.99f, result, "Uploading progress is not expected");
        assertThrows(TelegramUploadFileException.class, () -> forTest.getUploadingProgress(22));
    }


    private CompletableFuture<Boolean> completableTrue;
    private CompletableFuture<Boolean> completableFalse;
    private CompletableFuture<Boolean> completableNeverBoolean;
    private CompletableFuture<Integer> completableInteger;
    private CompletableFuture<Long> completableLong;
    private CompletableFuture<Integer> completableNeverInteger;
    private CompletableFuture<Long> completableNeverLong;
    private CompletableFuture<Pair<Boolean, Long>> completableTruePair;
    private CompletableFuture<Pair<Boolean, Long>> completableFalsePair;
    private CompletableFuture<Pair<Boolean, Long>> completableNeverPair;

    private static final int MOCKED_ID = 123;

    @BeforeEach
    void initCompletables()
    {
        completableTrue = new CompletableFuture<>();
        completableFalse = new CompletableFuture<>();
        completableNeverBoolean = new CompletableFuture<>();

        completableInteger = new CompletableFuture<>();
        completableLong = new CompletableFuture<>();
        completableNeverInteger = new CompletableFuture<>();
        completableNeverLong = new CompletableFuture<>();

        completableTruePair = new CompletableFuture<>();
        completableFalsePair = new CompletableFuture<>();
        completableNeverPair = new CompletableFuture<>();

        completableTrue.complete(true);
        completableFalse.complete(false);

        completableInteger.complete(MOCKED_ID);
        completableLong.complete((long)MOCKED_ID);

        completableTruePair.complete(Pair.with(true, 0L));
        completableFalsePair.complete(Pair.with(false, 0L));
    }
}
