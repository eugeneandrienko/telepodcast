package com.eugene_andrienko.telegram.api;

import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.impl.Telegram;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
                                      .thenReturn(completableNever);
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
        when(mockedTelegram.sendMessage(anyString())).thenReturn(completableTrue)  // 1
                                                     .thenReturn(completableFalse) // 2
                                                     .thenReturn(completableNever) // 3
                                                     .thenReturn(completableTrue)  // 4
                                                     .thenReturn(completableTrue); // 5
        when(mockedTelegram.isMessageInChat(anyString())).thenReturn(completableTrue)   // 1
                                                         .thenReturn(completableFalse)  // 4
                                                         .thenReturn(completableNever); // 5
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.sendMessage("TEST");
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST"));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST"));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST"));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendMessage("TEST"));
    }

    @Test
    @DisplayName("TelegramApi send audio test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendAudioTest()
    {
        File mockedFile = mock(File.class);
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendAudio(any(File.class))).thenReturn(completableTrue)  // 1
                                                       .thenReturn(completableFalse) // 2
                                                       .thenReturn(completableNever) // 3
                                                       .thenReturn(completableTrue)  // 4
                                                       .thenReturn(completableTrue); // 5
        when(mockedTelegram.isAudioInChat(any(File.class))).thenReturn(completableTrue)   // 1
                                                           .thenReturn(completableFalse)  // 4
                                                           .thenReturn(completableNever); // 5
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.sendAudio(mockedFile);
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(mockedFile));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(mockedFile));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(mockedFile));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendAudio(mockedFile));
    }

    @Test
    @DisplayName("TelegramApi send video test")
    @SneakyThrows(TelegramSendMessageException.class)
    void sendVideoTest()
    {
        File mockedFile = mock(File.class);
        Telegram mockedTelegram = mock(Telegram.class);
        when(mockedTelegram.sendVideo(any(File.class))).thenReturn(completableTrue)  // 1
                                                       .thenReturn(completableFalse) // 2
                                                       .thenReturn(completableNever) // 3
                                                       .thenReturn(completableTrue)  // 4
                                                       .thenReturn(completableTrue); // 5
        when(mockedTelegram.isVideoInChat(any(File.class))).thenReturn(completableTrue)   // 1
                                                           .thenReturn(completableFalse)  // 4
                                                           .thenReturn(completableNever); // 5
        TelegramApi forTest = new TelegramApi(mockedTelegram, 1);

        forTest.sendVideo(mockedFile);
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(mockedFile));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(mockedFile));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(mockedFile));
        assertThrows(TelegramSendMessageException.class, () -> forTest.sendVideo(mockedFile));
    }


    private CompletableFuture<Boolean> completableTrue;
    private CompletableFuture<Boolean> completableFalse;
    private CompletableFuture<Boolean> completableNever;

    @BeforeEach
    void initCompletables()
    {
        completableTrue = new CompletableFuture<>();
        completableFalse = new CompletableFuture<>();
        completableNever = new CompletableFuture<>();
        completableTrue.complete(true);
        completableFalse.complete(false);
    }
}
