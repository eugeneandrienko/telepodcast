package com.eugene_andrienko.youtubedl.api;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData.ContentType;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeDownloadException;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoDataException;
import com.eugene_andrienko.youtubedl.impl.AbstractYoutubeDl;
import java.io.File;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class YouTubeDlApiTest
{
    @Test
    @DisplayName("Init and close test")
    @SneakyThrows
    void initTest()
    {
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        try
        {
            @SuppressWarnings("unused") @Cleanup
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);
        }
        finally
        {
            verify(mockedYoutube, times(1)).close();
        }
    }

    @Test
    @DisplayName("Download audio test")
    @SneakyThrows
    void downloadAudioTest()
    {
        @Cleanup
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        @Cleanup
        YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);

        final String TEST_URL = "TEST URL";
        doNothing().when(mockedYoutube).downloadAudio(eq(TEST_URL));
        forTest.downloadAudio(TEST_URL);
        verify(mockedYoutube, times(1)).downloadAudio(TEST_URL);
    }

    @Test
    @DisplayName("Download video test")
    @SneakyThrows
    void downloadVideoTest()
    {
        @Cleanup
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        @Cleanup
        YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);

        final String TEST_URL = "TEST URL";
        doNothing().when(mockedYoutube).downloadVideo(eq(TEST_URL));
        forTest.downloadVideo(TEST_URL);
        verify(mockedYoutube, times(1)).downloadVideo(TEST_URL);
    }

    @Test
    @DisplayName("Get title test")
    @SneakyThrows
    void getTitleTest()
    {
        @Cleanup
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        @Cleanup
        YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);

        try
        {
            final String TEST_TITLE = "TEST TITLE";
            final String TEST_URL = "TEST URL";
            when(mockedYoutube.getTitle(eq(TEST_URL))).thenReturn(TEST_TITLE)
                                                      .thenThrow(YouTubeNoDataException.class);
            String result = forTest.getTitle(TEST_URL);
            assertEquals(TEST_TITLE, result, "Title not expected");
            result = forTest.getTitle(TEST_URL);
            assertNull(result, "Title should be null");
        }
        catch(YouTubeNoDataException ex)
        {
            fail("Fail to get title in test");
        }
    }

    @Test
    @DisplayName("Get download progress test")
    @SneakyThrows
    void getDownloadProgressTest()
    {
        @Cleanup
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        @Cleanup
        YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);

        final String TEST_URL = "TEST URL";
        final float EXPECTED_FLOAT = 42.42f;
        when(mockedYoutube.getDownloadProgress(eq(TEST_URL))).thenReturn(EXPECTED_FLOAT);

        float result = forTest.getDownloadProgress(TEST_URL);
        assertEquals(EXPECTED_FLOAT, result, "Download progress not expected");
    }

    @Test
    @DisplayName("Get download state test")
    @SneakyThrows
    void getDownloadStateTest()
    {
        @Cleanup
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        @Cleanup
        YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);

        final String TEST_URL = "TEST URL";
        final DownloadState EXPECTED_STATE = DownloadState.AUDIO_ENCODING;
        when(mockedYoutube.getDownloadState(eq(TEST_URL))).thenReturn(EXPECTED_STATE);

        DownloadState result = forTest.getDownloadState(TEST_URL);
        assertEquals(EXPECTED_STATE, result, "Download state not expected");
    }

    @Test
    @DisplayName("Get downloaded data test")
    @SneakyThrows
    void getDownloadedDataTest()
    {
        final String TEST_DESCRIPTION = "TEST DESCRIPTION";
        File mockedFile = mock(File.class);
        ContentType contentType = ContentType.VIDEO;
        int duration = 42;

        try
        {
            @Cleanup
            AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            @Cleanup
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);
            @Cleanup
            YoutubeData mockedData = new YoutubeData(mockedFile, TEST_DESCRIPTION, contentType,
                    duration);

            final String TEST_URL = "TEST URL";
            when(mockedYoutube.getDownloadedData(eq(TEST_URL))).thenReturn(mockedData)
                                                               .thenReturn(null);
            YoutubeData result = forTest.getDownloadedData(TEST_URL);
            assertEquals(mockedFile, result.getFile(), "File not expected");
            assertEquals(TEST_DESCRIPTION, result.getDescription(), "Description not expected");
            assertEquals(contentType, result.getContentType(), "Content type not expected");
            assertEquals(duration, result.getDurationSeconds(), "Duration not expected");
            assertThrows(YouTubeDownloadException.class, () -> forTest.getDownloadedData(TEST_URL));

            when(mockedFile.delete()).thenReturn(true);
        }
        catch(YouTubeDownloadException ex)
        {
            fail(ex);
        }
    }
}
