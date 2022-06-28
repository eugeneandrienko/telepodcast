package com.eugene_andrienko.youtubedl.impl;

import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData.ContentType;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeCannotRunException;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeNoDataException;
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

    private static final String FFMPEG = "ffmpeg";

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

    @Override
    public void canRun() throws YouTubeCannotRunException
    {
        String[] commandsToCheck = new String[]{YT_DLP, LAME, FFMPEG};
        for(String cmd : commandsToCheck)
        {
            try
            {
                ProcessBuilder processBuilder = new ProcessBuilder(cmd, "--help");
                Process process = processBuilder.start();
                int exitValue = process.waitFor();
                if(exitValue != 0)
                {
                    logger.error("System command \"{}\" not found!", cmd);
                    logger.debug("Return value of \"{} --help\" is: {}", cmd, exitValue);
                    throw new YouTubeCannotRunException(cmd);
                }
            }
            catch(IOException | InterruptedException ex)
            {
                logger.error("Failed to execute \"{}\" system command", cmd);
                logger.debug("Got error: ", ex);
                throw new YouTubeCannotRunException(cmd);
            }
        }
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

    private enum DataToGet
    {
        TITLE, DURATION
    }

    /**
     * Returns title for given YouTube video.
     *
     * @param url URL to YouTube video
     *
     * @return Title for YouTube video
     *
     * @throws YouTubeNoDataException Fail to get title
     */
    @Override
    public String getTitle(final String url) throws YouTubeNoDataException
    {
        return getData(url, DataToGet.TITLE);
    }

    /**
     * Returns duration for given YouTube video in seconds.
     *
     * Works synchronously.
     *
     * @param url URL to YouTube video
     *
     * @return Duration in seconds
     *
     * @throws YouTubeNoDataException Fail to get duration
     */
    private int getDuration(final String url) throws YouTubeNoDataException
    {
        String durationStr = getData(url, DataToGet.DURATION);
        try
        {
            return Integer.parseInt(durationStr);
        }
        catch(NumberFormatException ex)
        {
            logger.error("Failed to parse duration = {}", durationStr);
            throw new YouTubeNoDataException(ex);
        }
    }

    /**
     * Returns asked data for given YouTube video.
     *
     * Works synchronously.
     *
     * @param url       URL to YouTube video
     * @param dataToGet Data to get from YouTube.
     *
     * @return Asked data as string
     *
     * @throws YouTubeNoDataException Fail get asked data
     */
    private String getData(final String url, DataToGet dataToGet) throws YouTubeNoDataException
    {
        String data;
        switch(dataToGet)
        {
            case TITLE:
                data = "%(title)s";
                break;
            case DURATION:
                data = "%(duration)s";
                break;
            default:
                logger.error("Got unknown request for YouTube data: {}", dataToGet);
                throw new YouTubeNoDataException("Unknown request");
        }

        ProcessBuilder processBuilder = new ProcessBuilder(YT_DLP,
                "--no-colors",
                "--simulate",
                "--quiet",
                "--print", data,
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
                logger.error("Cannot read data ({}) from called yt-dlp for {}!", dataToGet, url);
                throw new YouTubeNoDataException("No data from yt-dlp");
            }

            return title;
        }
        catch(IOException ex)
        {
            logger.error("Got {} when obtain YouTube data ({}) from {}", ex, dataToGet, url);
            throw new YouTubeNoDataException(ex);
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
        File file = null;
        try
        {
            Process process = processBuilder.start();
            InputStream is = process.getInputStream();
            InputStream es = process.getErrorStream();
            InputStreamReader isr = new InputStreamReader(is);
            InputStreamReader esr = new InputStreamReader(es);
            BufferedReader br = new BufferedReader(isr);
            BufferedReader errors = new BufferedReader(esr);
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
                            downloadStateTable.put(url, DownloadState.AUDIO_ENCODING);
                        }
                        else if(contentType == ContentType.VIDEO)
                        {
                            downloadStateTable.put(url, DownloadState.VIDEO_ENCODING);
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
                while((output = errors.readLine()) != null)
                {
                    logger.error("External error: {}", output);
                }
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

            // Composing data for YoutubeData object:
            file = new File(downloadedFilePath);
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
            int duration = getDuration(url);

            YoutubeData result = new YoutubeData(file, description.toString(), contentType,
                    duration);
            downloadsTable.put(url, result);
            downloadStateTable.put(url, DownloadState.COMPLETE);
        }
        catch(IOException | YouTubeNoDataException ex)
        {
            logger.error("Failed to get data from YouTube (URL: {})", url);
            downloadStateTable.put(url, DownloadState.FAIL);
            if(file != null)
            {
                if(!file.delete())
                {
                    logger.error("Failed to delete downloaded file: {}", file.getAbsolutePath());
                }
            }
        }
    }

    /**
     * Increases volume of downloaded audio.
     *
     * Uses lame to increase volume. As a result {@code filename.mp3.mp3} file will be generated.
     * Then {@code filename.mp3} will be deleted and existing {@code filename.mp3.mp3} will be
     * renamed to {@code filename.mp3}.
     *
     * @param audioPath Path to downloaded MP3 file
     *
     * @throws IOException Fail to increase volume.
     */
    private void increaseVolume(String audioPath) throws IOException
    {
        logger.info("Increasing volume of {}", audioPath);

        ProcessBuilder processBuilder;
        try
        {
            processBuilder = new ProcessBuilder(LAME, "-S", "--scale", "3", audioPath);
            Process process = processBuilder.start();
            InputStream is = process.getErrorStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String output;

            logger.debug("Increasing {} volume with {}", audioPath, LAME);
            while((output = br.readLine()) != null)
            {
                logger.debug("LAME: {}", output);
            }

            File audioFile = new File(audioPath);
            if(!audioFile.delete())
            {
                logger.error("Failed to delete {} file", audioPath);
                throw new IOException("Cannot delete file");
            }

            // Rename file.mp3.mp3 after lame to file.mp3:
            File afterLame = new File(audioPath + ".mp3");
            if(!afterLame.renameTo(audioFile))
            {
                logger.error("Failed to rename {} to {}", audioPath + ".mp3", audioPath);
                throw new IOException("Cannot rename file");
            }
        }
        catch(IOException ex)
        {
            logger.error("Fail increase volume");
            throw ex;
        }
    }
}
