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

    /**
     * Initializes {@code AbstractYoutubeDl} object.
     *
     * @param countOfThreads Count of threads to download data from YouTube.
     *
     * @throws IOException Fail create a temporary directory for downloaded YouTube data.
     */
    public AbstractYoutubeDl(int countOfThreads) throws IOException
    {
        createTemporaryDirectory();
        logger.debug("Starting new fixed thread pool ({} threads) for YouTube downloader",
                countOfThreads);
        executorService = Executors.newFixedThreadPool(countOfThreads);
    }

    /**
     * For unit tests.
     *
     * @param service Mocked {@code ExecutorService}
     */
    AbstractYoutubeDl(ExecutorService service)
    {
        this.executorService = service;
    }

    /**
     * Creates a temporary directory for downloaded YouTube data.
     *
     * Creates the temporary directory in the system temp catalog (for example {@code /tmp/} in
     * Linux). Temporary directory name will start from {@code telepodcast} string and ends with
     * time of creation in nanoseconds.
     *
     * @throws IOException Fail create the temporary directory.
     */
    @SuppressWarnings("GrazieInspection")
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

    /**
     * Gracefully stop object's services.
     *
     * Stops executor service, removes downloaded files and temporary directory.
     *
     * @throws Exception Fail gracefully stop all services.
     */
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

    /**
     * Returns download progress in percents for given url.
     *
     * @param url URL
     *
     * @return Download progress in percents. Or {@code 0.0f} if no record about progress for
     * given {@code url} exists.
     */
    public float getDownloadProgress(String url)
    {
        Float progress = downloadProgressTable.get(url);
        return Objects.requireNonNullElse(progress, 0.0f);
    }

    /**
     * Returns download state for given url.
     *
     * @param url URL
     *
     * @return Download state as
     * {@link com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState}. Or
     * {@code DownloadState.NO_DATA} if no record about state exists.
     */
    public DownloadState getDownloadState(String url)
    {
        DownloadState state = downloadStateTable.get(url);
        return Objects.requireNonNullElse(state, DownloadState.NO_DATA);
    }

    /**
     * Returns downloaded data for given url.
     *
     * @param url URL
     *
     * @return Downloaded data as
     * {@link com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData}. Or null if no data.
     */
    public YoutubeData getDownloadedData(String url)
    {
        return downloadsTable.get(url);
    }
}
