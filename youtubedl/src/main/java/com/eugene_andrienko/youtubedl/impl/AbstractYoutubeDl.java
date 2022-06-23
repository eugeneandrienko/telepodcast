package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class AbstractYoutubeDl implements AutoCloseable, IYoutubeDl
{
    private final Logger logger = LoggerFactory.getLogger(AbstractYoutubeDl.class);

    File tempDirectory;
    final ConcurrentMap<String, YoutubeData> downloadsTable = new ConcurrentHashMap<>();
    final ConcurrentMap<String, Float> downloadProgressTable = new ConcurrentHashMap<>();
    final ConcurrentMap<String, DownloadState> downloadStateTable = new ConcurrentHashMap<>();
    ExecutorService executorService;

    public AbstractYoutubeDl(int countOfThreads) throws IOException
    {
        createTemporaryDirectory();
        logger.debug("Starting new fixed thread pool ({} threads) for YouTube downloader",
                countOfThreads);
        executorService = Executors.newFixedThreadPool(countOfThreads);
    }

    AbstractYoutubeDl(ExecutorService service)
    {
        this.executorService = service;
    }

    void createTemporaryDirectory() throws IOException
    {
        String tmpDir = System.getProperty("java.io.tmpdir");
        tempDirectory = new File(tmpDir, "telepodcast" + System.nanoTime());
        if(!tempDirectory.mkdir())
        {
            logger.error("Failed to create {} temp directory!", tempDirectory.getAbsolutePath());
            throw new IOException("Failed to create temporary directory");
        }
        logger.debug("Created temporary directory {} for YouTube files",
                tempDirectory.getAbsolutePath());
    }

    @Override
    public void close() throws Exception
    {
        executorService.shutdown();
        for(YoutubeData file : downloadsTable.values())
        {
            file.close();
        }
        if(tempDirectory != null)
        {
            if(!tempDirectory.delete())
            {
                logger.error("Failed to delete {} directory!", tempDirectory.getAbsolutePath());
                throw new IOException("Failed to delete temporary directory");
            }
            logger.debug("{} deleted", tempDirectory.getAbsolutePath());
        }
    }

    public float getDownloadProgress(String url)
    {
        Float progress = downloadProgressTable.get(url);
        return Objects.requireNonNullElse(progress, 0.0f);
    }

    public DownloadState getDownloadState(String url)
    {
        DownloadState state = downloadStateTable.get(url);
        return Objects.requireNonNullElse(state, DownloadState.NO_DATA);
    }

    public YoutubeData getDownloadedData(String url)
    {
        return downloadsTable.get(url);
    }
}
