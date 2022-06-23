package com.eugene_andrienko.youtubedl.impl;

import java.io.IOException;
import java.util.concurrent.ExecutorService;


public class YoutubeDlGenerator
{
    private static YoutubeDlGenerator INSTANCE;

    private YoutubeDlGenerator()
    {
    }

    public static YoutubeDlGenerator getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new YoutubeDlGenerator();
        }
        return INSTANCE;
    }

    public IYoutubeDl generate(int countOfThreads) throws IOException
    {
        return new YtDlp(countOfThreads);
    }

    // For testing purposes:
    IYoutubeDl generate(ExecutorService service)
    {
        return new YtDlp(service);
    }
}
