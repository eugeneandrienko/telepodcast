package com.eugene_andrienko.telepodcast.tui.windows;

import com.eugene_andrienko.telepodcast.tui.TUIException;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi;
import com.eugene_andrienko.youtubedl.api.exceptions.YouTubeCannotRunException;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.GridLayout.Alignment;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class LoadingTitlesWindow extends AbstractWindow
{
    private final MultiWindowTextGUI tui;
    private final int numberOfThreads;

    public LoadingTitlesWindow(MultiWindowTextGUI tui, int numberOfThreads)
    {
        this.tui = tui;
        this.numberOfThreads = numberOfThreads;
    }

    public Map<String, String> start(Set<String> urls) throws TUIException
    {
        ProgressBar progressBar = new ProgressBar(0, urls.size(), 40);
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(1).setLeftMarginSize(1).setRightMarginSize(1))
             .setLayoutData(GridLayout.createLayoutData(
                     Alignment.BEGINNING, Alignment.FILL, true, true));
        panel.addComponent(new EmptySpace(TerminalSize.ONE))
             .addComponent(progressBar)
             .addComponent(new EmptySpace(TerminalSize.ONE));

        BasicWindow loadingTitlesWindow = createCenteredWindow("Loading YouTube video titles");
        loadingTitlesWindow.setComponent(panel);

        tui.addWindow(loadingTitlesWindow);
        updateScreen(tui, log);

        Map<String, String> result = new HashMap<>();
        try
        {
            @Cleanup
            YouTubeDlApi youtube = new YouTubeDlApi(numberOfThreads);
            checkYouTubeDownloader(youtube);

            for(String url : urls)
            {
                String title = youtube.getTitle(url);
                result.put(url, title);
                log.debug("Processing {}, got {} title", url, title);
                progressBar.setValue(progressBar.getValue() + 1);
                tui.updateScreen();
            }
        }
        catch(IOException ex)
        {
            log.error("Failed to instantiate youtubedl library", ex);
            new MessageDialogBuilder()
                    .setTitle("YouTube downloader error")
                    .setText("Failed to get video titles")
                    .addButton(MessageDialogButton.OK)
                    .build()
                    .showDialog(tui);
            throw new TUIException(ex);
        }
        catch(TUIException ex)
        {
            throw ex;
        }
        catch(Exception ex)
        {
            log.error("Failed to properly close youtubedl library", ex);
            new MessageDialogBuilder()
                    .setTitle("YouTube downloader error")
                    .setText("Failed to properly close resources for YouTube downloader")
                    .addButton(MessageDialogButton.OK)
                    .build()
                    .showDialog(tui);
            throw new TUIException(ex);
        }

        tui.removeWindow(loadingTitlesWindow);
        updateScreen(tui, log);
        return result;
    }

    /**
     * Checks what YouTube downloader can be executed on this system.
     *
     * @param youtube Initialized {@code YouTubeDlApi} object.
     *
     * @throws TUIException Downloader cannot be executed.
     */
    private void checkYouTubeDownloader(YouTubeDlApi youtube) throws TUIException
    {
        try
        {
            youtube.canRun();
        }
        catch(YouTubeCannotRunException ex)
        {
            new MessageDialogBuilder()
                    .setTitle("Error!")
                    .setText(String.format("Program \"%s\" not found in system! Please " +
                                           "install it first.", ex.getMessage()))
                    .addButton(MessageDialogButton.OK)
                    .build()
                    .showDialog(tui);
            throw new TUIException(ex);
        }
    }
}
