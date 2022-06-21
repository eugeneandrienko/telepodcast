package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


public class TelegramApiTest
{
    @Test
    @DisplayName("TelegramApi init test")
    void initTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);
        // Should not throw any exceptions here
    }

    @Test
    @DisplayName("TelegramApi login test")
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
    @DisplayName("TelegramApi send message test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendMessageTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendMessage(anyString())).thenReturn(completableTrue)
                                                     .thenReturn(completableFalse)
                                                     .thenReturn(completableNeverBoolean);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.sendMessage("TEST");
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST"));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST"));
    }

    @Test
    @DisplayName("TelegramApi upload audio test")
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
    @DisplayName("TelegramApi send audio test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendAudioTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendAudio(anyInt())).thenReturn(completableTrue)
                                                .thenReturn(completableFalse)
                                                .thenReturn(completableNeverBoolean);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.sendAudio(123);
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(123));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(123));
    }

    @Test
    @DisplayName("TelegramApi upload video test")
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
    @DisplayName("TelegramApi send video test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendVideoTest()
    {
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendVideo(anyInt())).thenReturn(completableTrue)
                                                .thenReturn(completableFalse)
                                                .thenReturn(completableNeverBoolean);
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.sendVideo(123);
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(123));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(123));
    }

    @Test
    @DisplayName("TelegramApi get uploading progress test")
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
    private CompletableFuture<Integer> completableNeverInteger;

    private static final int MOCKED_ID = 123;

    @BeforeEach
    void initCompletables()
    {
        completableTrue = new CompletableFuture<>();
        completableFalse = new CompletableFuture<>();
        completableNeverBoolean = new CompletableFuture<>();
        completableInteger = new CompletableFuture<>();
        completableNeverInteger = new CompletableFuture<>();
        completableTrue.complete(true);
        completableFalse.complete(false);
        completableInteger.complete(MOCKED_ID);
    }
}
