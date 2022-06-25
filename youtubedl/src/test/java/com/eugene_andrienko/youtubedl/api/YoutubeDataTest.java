package com.eugene_andrienko.youtubedl.api;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData.ContentType;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class YoutubeDataTest
{
    @Test
    @DisplayName("Constructor test")
    void constructorTest()
    {
        final String TEST_DESCRIPTION = "TEST DESCRIPTION";
        File mockedFile = mock(File.class);
        ContentType contentType = ContentType.AUDIO;

        @SuppressWarnings("resource")
        YoutubeData forTest = new YoutubeData(mockedFile, TEST_DESCRIPTION, contentType);
        assertEquals(mockedFile, forTest.getFile());
        assertEquals(TEST_DESCRIPTION, forTest.getDescription());
    }

    @Test
    @DisplayName("Close test")
    void closeTest()
    {
        File mockedFile = mock(File.class);
        when(mockedFile.delete()).thenReturn(true).thenReturn(false);

        YoutubeData forTest = new YoutubeData(mockedFile, "", ContentType.VIDEO);
        try
        {
            forTest.close();
        }
        catch(Exception e)
        {
            fail(e);
        }

        assertThrows(IOException.class, forTest::close);

        verify(mockedFile, times(2)).delete();
    }
}
