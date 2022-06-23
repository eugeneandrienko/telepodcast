package com.eugene_andrienko.youtubedl.api;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeDownloadException;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoTitleException;
import com.eugene_andrienko.youtubedl.impl.AbstractYoutubeDl;
import java.io.File;
import java.io.IOException;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class YouTubeDlApiTest
{
    @Test
    @DisplayName("Init test")
    void initTest()
    {
        //noinspection EmptyTryBlock
        try(YouTubeDlApi forTest = new YouTubeDlApi(1))
        {
        }
        catch(IOException e)
        {
            fail("Fail to initialize YouTubeDlApi");
        }
        catch(Exception e)
        {
            fail("Fail to close YouTubeDlApi");
        }
    }

    @Test
    @DisplayName("Download audio test")
    void downloadAudioTest()
    {
        try(AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube))
        {
            final String TEST_URL = "TEST URL";
            doNothing().when(mockedYoutube).downloadAudio(eq(TEST_URL));
            forTest.downloadAudio(TEST_URL);
            verify(mockedYoutube, times(1)).downloadAudio(TEST_URL);
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }

    @Test
    @DisplayName("Download video test")
    void downloadVideoTest()
    {
        try(AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube))
        {
            final String TEST_URL = "TEST URL";
            doNothing().when(mockedYoutube).downloadVideo(eq(TEST_URL));
            forTest.downloadVideo(TEST_URL);
            verify(mockedYoutube, times(1)).downloadVideo(TEST_URL);
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }

    @Test
    @DisplayName("Get title test")
    void getTitleTest()
    {
        try(AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube))
        {
            final String TEST_TITLE = "TEST TITLE";
            final String TEST_URL = "TEST URL";
            when(mockedYoutube.getTitle(eq(TEST_URL))).thenReturn(TEST_TITLE)
                                                      .thenThrow(YouTubeNoTitleException.class);
            String result = forTest.getTitle(TEST_URL);
            assertEquals(TEST_TITLE, result, "Title not expected");
            result = forTest.getTitle(TEST_URL);
            assertNull(result, "Title should be null");
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }

    @Test
    @DisplayName("Get download progress test")
    void getDownloadProgressTest()
    {
        try(AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube))
        {
            final String TEST_URL = "TEST URL";
            final float EXPECTED_FLOAT = 42.42f;
            when(mockedYoutube.getDownloadProgress(eq(TEST_URL))).thenReturn(EXPECTED_FLOAT);

            float result = forTest.getDownloadProgress(TEST_URL);
            assertEquals(EXPECTED_FLOAT, result, "Download progress not expected");
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }

    @Test
    @DisplayName("Get download state test")
    void getDownloadStateTest()
    {
        try(AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube))
        {
            final String TEST_URL = "TEST URL";
            final DownloadState EXPECTED_STATE = DownloadState.RECODING_AUDIO;
            when(mockedYoutube.getDownloadState(eq(TEST_URL))).thenReturn(EXPECTED_STATE);

            DownloadState result = forTest.getDownloadState(TEST_URL);
            assertEquals(EXPECTED_STATE, result, "Download state not expected");
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }

    @Test
    @DisplayName("Get downloaded data test")
    void getDownloadedDataTest()
    {
        final String TEST_DESCRIPTION = "TEST DESCRIPTION";
        File mockedFile = mock(File.class);

        try(AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
            YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube);
            YoutubeData mockedData = new YoutubeData(mockedFile, TEST_DESCRIPTION))
        {
            final String TEST_URL = "TEST URL";
            when(mockedYoutube.getDownloadedData(eq(TEST_URL))).thenReturn(mockedData)
                                                               .thenReturn(null);
            YoutubeData result = forTest.getDownloadedData(TEST_URL);
            assertEquals(mockedFile, result.getFile(), "File not expected");
            assertEquals(TEST_DESCRIPTION, result.getDescription(), "Description not expected");
            assertThrows(YouTubeDownloadException.class, () -> forTest.getDownloadedData(TEST_URL));

            when(mockedFile.delete()).thenReturn(true);
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }

    @Test
    @DisplayName("Close test")
    @SneakyThrows
    void closeTest()
    {
        AbstractYoutubeDl mockedYoutube = mock(AbstractYoutubeDl.class);
        //noinspection EmptyTryBlock
        try(YouTubeDlApi forTest = new YouTubeDlApi(mockedYoutube))
        {
        }
        catch(Exception ex)
        {
            fail(ex);
        }
        verify(mockedYoutube, times(1)).close();
    }
}
