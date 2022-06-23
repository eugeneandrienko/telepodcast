package com.eugene_andrienko.youtubedl.impl;

import java.util.concurrent.ExecutorService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;


public class YoutubeDlGeneratorTest
{
    @Test
    @DisplayName("Get instance test")
    void getInstanceTest()
    {
        YoutubeDlGenerator forTest = YoutubeDlGenerator.getInstance();
        YoutubeDlGenerator forTest2 = YoutubeDlGenerator.getInstance();
        assertEquals(YoutubeDlGenerator.class, forTest.getClass());
        assertEquals(YoutubeDlGenerator.class, forTest2.getClass());
        assertSame(forTest, forTest2, "getInstance should return the same object");
    }

    @Test
    @DisplayName("generate() test")
    @SneakyThrows
    void generateTest()
    {
        ExecutorService mockedService = mock(ExecutorService.class);
        doNothing().when(mockedService).shutdown();
        YoutubeDlGenerator forTest = YoutubeDlGenerator.getInstance();
        IYoutubeDl ydl = forTest.generate(mockedService);
        ydl.close();
        assertEquals(YtDlp.class, ydl.getClass());
        verify(mockedService, times(1)).shutdown();
    }
}
