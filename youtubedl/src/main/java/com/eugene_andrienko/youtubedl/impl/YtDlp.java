package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoTitleException;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class YtDlp extends AbstractYoutubeDl
{
    private final Logger logger = LoggerFactory.getLogger(YtDlp.class);

    private static final String YT_DLP = "yt-dlp";
    private static final String LAME = "lame";
    private static final String RM = "rm";
    private static final String RENAME = "rename";

    private enum ContentType
    {
        AUDIO, VIDEO
    }

    /**
     * Initializes {@code YtDlp} object.
     *
     * @param countOfThreads Count of thread to download videos from YouTube.
     *
     * @throws IOException Fail initialize object.
     */
    public YtDlp(int countOfThreads) throws IOException
    {
        super(countOfThreads);
    }

    /**
     * For unit-tests.
     *
     * @param service Mocked {@code ExecutorService} object.
     */
    YtDlp(ExecutorService service)
    {
        super(service);
    }

    /**
     * Asynchronously downloads audio from YouTube.
     *
     * @param url URL to YouTube video
     */
    @Override
    public void downloadAudio(final String url)
    {
        downloadProgressTable.put(url, 0.0f);
        downloadStateTable.put(url, DownloadState.DOWNLOADING);

        executorService.execute(() -> {
            logger.info("Downloading {}", url);

            ProcessBuilder processBuilder = new ProcessBuilder(YT_DLP,
                    "--write-description",
                    "--extract-audio",
                    "--audio-format", "mp3",
                    "--embed-thumbnail",
                    "--no-colors",
                    "--quiet",
                    "--no-simulate",
                    "--progress",
                    "--newline",
                    "--progress-template", "%(progress._percent_str)s",
                    "--print", "after_move:%(filepath)s",
                    "--output", "%(title)s.%(ext)s",
                    url);
            download(url, processBuilder, ContentType.AUDIO);
        });
    }

    /**
     * Asynchronously downloads video from YouTube.
     *
     * @param url URL to YouTube video
     */
    @Override
    public void downloadVideo(final String url)
    {
        downloadProgressTable.put(url, 0.0f);
        downloadStateTable.put(url, DownloadState.DOWNLOADING);

        executorService.execute(() -> {
            logger.info("Downloading {}", url);

            ProcessBuilder processBuilder = new ProcessBuilder(YT_DLP,
                    "--write-description",
                    "--embed-thumbnail",
                    "--recode-video", "mp4",
                    "--no-colors",
                    "--quiet",
                    "--no-simulate",
                    "--progress",
                    "--newline",
                    "--progress-template", "%(progress._percent_str)s",
                    "--print", "after_move:%(filepath)s",
                    "--output", "%(title)s.%(ext)s",
                    url);
            download(url, processBuilder, ContentType.VIDEO);
        });
    }

    /**
     * Returns title for given YouTube video.
     *
     * @param url URL to YouTube video
     *
     * @return Title for YouTube video
     *
     * @throws YouTubeNoTitleException Fail to get title
     */
    @Override
    public String getTitle(final String url) throws YouTubeNoTitleException
    {
        ProcessBuilder processBuilder = new ProcessBuilder(YT_DLP,
                "--no-colors",
                "--simulate",
                "--quiet",
                "--print", "%(title)s",
                url);
        try
        {
            Process process = processBuilder.start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String title = "", output;

            while((output = br.readLine()) != null)
            {
                Thread.yield();
                title = output;
            }
            if(title.equals(""))
            {
                logger.error("Cannot read data from called yt-dlp!");
                throw new YouTubeNoTitleException("No data from yt-dlp");
            }

            return title;
        }
        catch(IOException ex)
        {
            logger.error("Got {} when obtain YouTube title from {}", ex, url);
            throw new YouTubeNoTitleException(ex);
        }
    }

    /**
     * Downloads data from YouTube.
     *
     * @param url            URL to YouTube video
     * @param processBuilder Initialized {@code ProcessBuilder} object.
     * @param contentType    Result type — see {@see #ContentType} values.
     */
    private void download(String url, ProcessBuilder processBuilder, ContentType contentType)
    {
        processBuilder.directory(tempDirectory);
        try
        {
            Process process = processBuilder.start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String downloadedFilePath = "";
            String output;

            while((output = br.readLine()) != null)
            {
                Thread.yield();
                Pattern progressPattern = Pattern.compile("\\s*(\\d+\\.?\\d+)%");
                Matcher matcher = progressPattern.matcher(output);
                if(matcher.matches())
                {
                    float progress = Float.parseFloat(matcher.group(1));
                    downloadProgressTable.put(url, progress);
                    if(progress >= 99.9f)
                    {
                        if(contentType == ContentType.AUDIO)
                        {
                            downloadStateTable.put(url, DownloadState.RECODING_AUDIO);
                        }
                        else if(contentType == ContentType.VIDEO)
                        {
                            downloadStateTable.put(url, DownloadState.RECODING_VIDEO);
                        }
                        else
                        {
                            logger.error("Unknown content type: {}", contentType);
                        }
                    }
                }
                else
                {
                    downloadedFilePath = output;
                }
            }
            if(downloadedFilePath.equals(""))
            {
                logger.error("Cannot read data from called yt-dlp!");
                downloadStateTable.put(url, DownloadState.FAIL);
                return;
            }

            logger.debug("Downloaded file: {}", downloadedFilePath);
            downloadStateTable.put(url, DownloadState.DOWNLOADED);

            if(contentType == ContentType.AUDIO)
            {
                downloadStateTable.put(url, DownloadState.VOLUME_INCREASE);
                increaseVolume(downloadedFilePath);
            }

            File file = new File(downloadedFilePath);
            File descriptionFile = new File(downloadedFilePath.substring(
                    0, downloadedFilePath.length() - 3) + "description");
            BufferedReader descriptionReader = new BufferedReader(new FileReader(descriptionFile));
            StringBuilder description = new StringBuilder();
            while((output = descriptionReader.readLine()) != null)
            {
                description.append(output).append(System.lineSeparator());
            }
            if(!descriptionFile.delete())
            {
                logger.error("Failed to delete description file: {}",
                        descriptionFile.getAbsolutePath());
            }

            YoutubeData result = new YoutubeData(file, description.toString());
            downloadsTable.put(url, result);
            downloadStateTable.put(url, DownloadState.COMPLETE);
        }
        catch(IOException ex)
        {
            logger.error("Failed call yt-dlp to download from: {}!", url);
            downloadStateTable.put(url, DownloadState.FAIL);
        }
    }

    /**
     * Increases volume of downloaded audio.
     *
     * Uses lame to increase volume. As a result {@code filename.mp3.mp3} file will be generated.
     * Then {@code filename.mp3} will be deleted and existing {@code filename.mp3.mp3} will be
     * renamed to {@code filename.mp3}.
     *
     * @param mp3 Path to downloaded MP3 file
     *
     * @throws IOException Fail to increase volume.
     */
    private void increaseVolume(String mp3) throws IOException
    {
        logger.info("Increasing volume of {}", mp3);

        ProcessBuilder processBuilder;
        try
        {
            processBuilder = new ProcessBuilder(LAME, "-S", "--scale", "3", mp3);
            Process process = processBuilder.start();
            InputStream is = process.getErrorStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String output;

            logger.debug("Increasing {} volume with {}", mp3, LAME);
            while((output = br.readLine()) != null)
            {
                logger.debug("LAME: {}", output);
            }

            processBuilder = new ProcessBuilder(RM, mp3);
            processBuilder.start();

            // Rename file.mp3.mp3 after lame to file.mp3:
            processBuilder = new ProcessBuilder(RENAME, ".mp3.mp3", ".mp3", mp3 + ".mp3");
            processBuilder.start();
        }
        catch(IOException ex)
        {
            logger.error("Failed call lame to increase volume");
            throw ex;
        }
    }
}
