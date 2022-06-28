package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData.ContentType;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoDataException;
import java.io.File;
import java.util.concurrent.ExecutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class AbstractYoutubeDlTest
{
    @Test
    @DisplayName("Close test")
    void createTemporaryDirectoryTest()
    {
        ExecutorService mockedService = mock(ExecutorService.class);
        try(NonAbstractYoutubeDl forTest = new NonAbstractYoutubeDl(mockedService))
        {
            doNothing().when(mockedService).shutdown();
        }
        catch(Exception ex)
        {
            fail(ex);
        }
        verify(mockedService, times(1)).shutdown();
    }

    @Test
    @DisplayName("Get download progress test")
    void getDownloadProgressTest()
    {
        ExecutorService mockedService = mock(ExecutorService.class);
        try(NonAbstractYoutubeDl forTest = new NonAbstractYoutubeDl(mockedService))
        {
            final String TEST_URL = "TEST URL";
            final float TEST_PROGRESS = 42.42f;
            forTest.setDownloadProgress(TEST_URL, TEST_PROGRESS);

            float result = forTest.getDownloadProgress(TEST_URL);
            assertEquals(TEST_PROGRESS, result, "Progress value not expected");
            result = forTest.getDownloadProgress("WRONG URL");
            assertEquals(0.0f, result, "Progress value is not 0.0");
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
        ExecutorService mockedService = mock(ExecutorService.class);
        try(NonAbstractYoutubeDl forTest = new NonAbstractYoutubeDl(mockedService))
        {
            final String TEST_URL = "TEST URL";
            final DownloadState TEST_STATE = DownloadState.VIDEO_ENCODING;
            forTest.setDownloadState(TEST_URL, TEST_STATE);

            DownloadState result = forTest.getDownloadState(TEST_URL);
            assertEquals(TEST_STATE, result, "State value not expected");
            result = forTest.getDownloadState("WRONG URL");
            assertEquals(DownloadState.NO_DATA, result, "State value is not NO_DATA");
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
        ExecutorService mockedService = mock(ExecutorService.class);
        try(NonAbstractYoutubeDl forTest = new NonAbstractYoutubeDl(mockedService))
        {
            final String TEST_URL = "TEST URL";
            File mockedFile = mock(File.class);
            final String TEST_DESCRIPTION = "TEST DESCRIPTION";
            YoutubeData dataForTest = new YoutubeData(mockedFile, TEST_DESCRIPTION,
                    ContentType.AUDIO);

            forTest.setDownloadedData(TEST_URL, dataForTest);
            YoutubeData result = forTest.getDownloadedData(TEST_URL);
            assertEquals(mockedFile, result.getFile(), "File not expected");
            assertEquals(TEST_DESCRIPTION, result.getDescription(), "Description not expected");
            assertEquals(ContentType.AUDIO, result.getContentType(), "Content type not expected");
            result = forTest.getDownloadedData("WRONG URL");
            assertNull(result);

            when(mockedFile.delete()).thenReturn(true);
        }
        catch(Exception ex)
        {
            fail(ex);
        }
    }


    private static class NonAbstractYoutubeDl extends AbstractYoutubeDl
    {
        NonAbstractYoutubeDl(ExecutorService executorService)
        {
            super(executorService);
        }

        @Override
        public void downloadAudio(final String url)
        {
        }

        @Override
        public void downloadVideo(final String url)
        {
        }

        @Override
        public String getTitle(final String url) throws YouTubeNoDataException
        {
            return null;
        }

        public void setDownloadProgress(String url, float progress)
        {
            downloadProgressTable.put(url, progress);
        }

        public void setDownloadState(String url, DownloadState state)
        {
            downloadStateTable.put(url, state);
        }

        public void setDownloadedData(String url, YoutubeData data)
        {
            downloadsTable.put(url, data);
        }
    }
}
