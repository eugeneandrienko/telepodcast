package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import java.util.concurrent.ExecutorService;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


public class YtDlpTest
{
    private ExecutorService mockedService;

    @Test
    @DisplayName("Constructor test")
    @SneakyThrows
    void constructorTest()
    {
        try
        {
            @Cleanup
            YtDlp forTest = new YtDlp(mockedService);
            assertEquals(YtDlp.class, forTest.getClass());
        }
        finally
        {
            verify(mockedService, times(1)).shutdown();
        }
    }

    @Test
    @DisplayName("Download audio test")
    @SneakyThrows
    void downloadAudioTest()
    {
        @Cleanup
        YtDlp forTest = new YtDlp(mockedService);
        final String TEST_URL = "TEST";
        forTest.downloadAudio(TEST_URL);
        assertEquals(0.0f, forTest.getDownloadProgress(TEST_URL));
        assertEquals(DownloadState.DOWNLOADING, forTest.getDownloadState(TEST_URL));
    }

    @Test
    @DisplayName("Download video test")
    @SneakyThrows
    void downloadVideoTest()
    {
        @Cleanup
        YtDlp forTest = new YtDlp(mockedService);
        final String TEST_URL = "TEST";
        forTest.downloadVideo(TEST_URL);
        assertEquals(0.0f, forTest.getDownloadProgress(TEST_URL));
        assertEquals(DownloadState.DOWNLOADING, forTest.getDownloadState(TEST_URL));
    }

    @BeforeEach
    void initializeBeforeTest()
    {
        mockedService = mock(ExecutorService.class);
        doNothing().when(mockedService).shutdown();
        doNothing().when(mockedService).execute(any(Runnable.class));
    }
}
