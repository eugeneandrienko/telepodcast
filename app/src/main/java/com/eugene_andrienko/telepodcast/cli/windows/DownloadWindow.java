package com.eugene_andrienko.telepodcast.cli.windows;

import com.eugene_andrienko.telegram.api.TelegramApi;
import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import com.eugene_andrienko.telegram.api.exceptions.TelegramUploadFileException;
import com.eugene_andrienko.telepodcast.TextHelper;
import com.eugene_andrienko.telepodcast.cli.CLIException;
import com.eugene_andrienko.telepodcast.cli.DownloadOptions;
import com.eugene_andrienko.telepodcast.cli.DownloadOptions.DownloadType;
import com.eugene_andrienko.telepodcast.cli.components.CenteredWaitingDialog;
import com.eugene_andrienko.telepodcast.cli.components.ImprovedProgressBar;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.DownloadState;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi.YoutubeData.ContentType;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeDownloadException;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.GridLayout.Alignment;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DownloadWindow extends AbstractWindow
{
    private final Logger logger = LoggerFactory.getLogger(DownloadWindow.class);

    private final MultiWindowTextGUI cli;
    private final TelegramOptions options;
    private final int threads;
    private final TextColor LABEL_DEFAULT_COLOR;
    private final AtomicInteger countOfProcessedFiles;
    private final ExecutorService executorService;

    public DownloadWindow(MultiWindowTextGUI cli, TelegramOptions options, int threads)
    {
        super();
        this.cli = cli;
        this.options = options;
        this.threads = threads;
        this.LABEL_DEFAULT_COLOR = new Label("").getForegroundColor();
        this.countOfProcessedFiles = new AtomicInteger(0);
        this.executorService = Executors.newCachedThreadPool();
    }

    public void start(List<DownloadOptions> downloads) throws CLIException
    {
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(3).setLeftMarginSize(1).setRightMarginSize(1))
             .setLayoutData(GridLayout.createLayoutData(
                     Alignment.FILL, Alignment.FILL, true, true));

        BasicWindow window = createCenteredWindow("Processing");
        window.setComponent(panel);

        // Add table heading:
        panel.addComponent(new EmptySpace(TerminalSize.ONE))
             .addComponent(new EmptySpace(TerminalSize.ONE))
             .addComponent(new EmptySpace(TerminalSize.ONE))
             .addComponent(new Label("YouTube video").addStyle(SGR.BOLD))
             .addComponent(new Label("Progress").addStyle(SGR.BOLD))
             .addComponent(new Label("State").addStyle(SGR.BOLD))
             .addComponent(new EmptySpace(TerminalSize.ONE))
             .addComponent(new EmptySpace(TerminalSize.ONE))
             .addComponent(new EmptySpace(TerminalSize.ONE));

        try(YouTubeDlApi youtube = new YouTubeDlApi(threads);
            TelegramApi telegram = new TelegramApi(options))
        {
            // Login to Telegram:
            CenteredWaitingDialog waitTelegramLogin = CenteredWaitingDialog
                    .showDialog(cli, "Wait", "Login to Telegram");
            updateScreen(cli, logger);
            telegram.login();
            waitTelegramLogin.close();
            updateScreen(cli, logger);

            // Add table elements:
            for(DownloadOptions option : downloads)
            {
                Label title = new Label(formatTitle(option.getTitle()));
                ImprovedProgressBar progressBar = new ImprovedProgressBar(0, 100, 10);
                Label status = new Label("");
                panel.addComponent(title).addComponent(progressBar).addComponent(status);
                processData(youtube, telegram, option, progressBar, status);
            }

            // Add extra space:
            panel.addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new EmptySpace(TerminalSize.ONE));

            cli.addWindow(window);
            while(countOfProcessedFiles.get() < downloads.size())
            {
                updateScreen(cli, logger);
                try
                {
                    //noinspection BusyWait
                    Thread.sleep(100);
                }
                catch(InterruptedException ex)
                {
                    logger.error("Sleep interrupted");
                    continue;
                }
                Thread.yield();
            }
            new MessageDialogBuilder().setTitle("Information")
                                      .setText("All files processed")
                                      .addButton(MessageDialogButton.Close)
                                      .build()
                                      .showDialog(cli);
        }
        catch(TelegramInitException ex)
        {
            new MessageDialogBuilder()
                    .setTitle("Telegram error")
                    .setText("Failed to login to Telegram!")
                    .addButton(MessageDialogButton.OK)
                    .build()
                    .showDialog(cli);
            throw new CLIException(ex);
        }
        catch(IOException ex)
        {
            logger.error("Unrecoverable CLI exception", ex);
            throw new CLIException(ex);
        }
        catch(Exception ex)
        {
            logger.error("Failed to properly close resources", ex);
            throw new CLIException(ex);
        }

        executorService.shutdown();
        cli.removeWindow(window);
    }

    private void processData(@NonNull YouTubeDlApi youtube, @NonNull TelegramApi telegram,
            DownloadOptions download, ImprovedProgressBar progressBar, Label status)
            throws IOException
    {
        executorService.execute(() -> {
            YoutubeData youtubeData = downloadFileStage(youtube, download, progressBar, status);
            int localFileId = uploadFileStage(telegram, youtubeData, progressBar, status);
            sendMessageStage(telegram, youtubeData, localFileId, progressBar, status);
            int countOfProcessed = countOfProcessedFiles.incrementAndGet();
            logger.debug("{} links processed", countOfProcessed);
        });
    }

    private YoutubeData downloadFileStage(@NonNull YouTubeDlApi youtube, DownloadOptions download,
            ImprovedProgressBar progressBar, Label status)
    {
        String url = download.getUrl();
        DownloadType downloadType = download.getDownloadType();
        if(downloadType == DownloadType.AUDIO)
        {
            youtube.downloadAudio(url);
        }
        else if(downloadType == DownloadType.VIDEO)
        {
            youtube.downloadVideo(url);
        }

        DownloadState state = youtube.getDownloadState(url);
        while(state != DownloadState.COMPLETE && state != DownloadState.FAIL)
        {
            state = youtube.getDownloadState(url);
            float progress = youtube.getDownloadProgress(url);
            status.setForegroundColor(LABEL_DEFAULT_COLOR).setText(state.toString());
            switch(state)
            {
                case DOWNLOADING:
                    progressBar.setValue((int)progress);
                    break;
                case VOLUME_INCREASE:
                case AUDIO_ENCODING:
                case VIDEO_ENCODING:
                    progressBar.busyWaiting();
                    break;
                case COMPLETE:
                    status.setForegroundColor(TextColor.ANSI.GREEN);
                    progressBar.hide();
                    try
                    {
                        return youtube.getDownloadedData(url);
                    }
                    catch(YouTubeDownloadException e)
                    {
                        status.setForegroundColor(TextColor.ANSI.RED)
                              .setText(DownloadState.FAIL.toString());
                        logger.error("Failed to download {}", url);
                        return null;
                    }
                case FAIL:
                    status.setForegroundColor(TextColor.ANSI.RED);
                    progressBar.hide();
                    logger.error("Fail when downloading {}", url);
                    return null;
            }
        }
        return null;
    }

    private int uploadFileStage(@NonNull TelegramApi telegram, YoutubeData youtubeData,
            ImprovedProgressBar progressBar, Label status)
    {
        if(youtubeData == null)
        {
            return -1;
        }

        ContentType contentType = youtubeData.getContentType();
        File file = youtubeData.getFile();
        int fileId = -1;

        try
        {
            switch(contentType)
            {
                case AUDIO:
                    fileId = telegram.uploadAudio(file);
                    break;
                case VIDEO:
                    fileId = telegram.uploadVideo(file);
                    break;
            }

            progressBar.setValue(0);
            status.setForegroundColor(LABEL_DEFAULT_COLOR).setText("UPLOADING");

            float progress = telegram.getUploadingProgress(fileId);
            while(progress <= 99.9f)
            {
                progress = telegram.getUploadingProgress(fileId);
                progressBar.setValue((int)progress);
            }
            progressBar.setValue(100);
            status.setForegroundColor(TextColor.ANSI.GREEN).setText("UPLOADED");
        }
        catch(TelegramUploadFileException ex)
        {
            logger.error("Failed to upload file {}", file.getAbsolutePath());
            progressBar.hide();
            status.setForegroundColor(TextColor.ANSI.RED).setText("UPLOAD FAIL");
        }
        return fileId;
    }

    private void sendMessageStage(@NonNull TelegramApi telegram, YoutubeData data, int localFileId,
            ImprovedProgressBar progressBar, Label status)
    {
        if(localFileId < 0 || data == null)
        {
            return;
        }

        // TODO: clear description from marketing text, links and hashtags
        List<String> description = prepareDescription4Telegram(data.getDescription());
        ContentType contentType = data.getContentType();

        progressBar.busyWaiting();

        try
        {
            long messageId = 0;
            switch(contentType)
            {
                case AUDIO:
                    messageId = telegram.sendAudio(localFileId, null, data.getDurationSeconds(),
                            messageId);
                    break;
                case VIDEO:
                    messageId = telegram.sendVideo(localFileId, null, data.getDurationSeconds(),
                            messageId);
                    break;
            }
            logger.debug("Sent message: {}", messageId);
            for(String s : description)
            {
                logger.debug("Send text message in reply to {}", messageId);
                messageId = telegram.sendMessage(s, messageId);
                logger.debug("Sent text message {}", messageId);
            }
            status.setForegroundColor(TextColor.ANSI.GREEN).setText("SENT");
            progressBar.hide();
        }
        catch(TelegramSendMessageException ex)
        {
            logger.error("Failed to send telegram message", ex);
            status.setForegroundColor(TextColor.ANSI.RED).setText("FAIL");
            progressBar.hide();
        }
    }

    /**
     * Prepare YouTube description for Telegram.
     *
     * @param string YouTube video description
     *
     * @return List of string to send to Telegram.
     */
    private List<String> prepareDescription4Telegram(String string)
    {
        return TextHelper.splitByWords(string, TelegramApi.MESSAGE_LENGTH);
    }
}
