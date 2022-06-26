package com.eugene_andrienko.telepodcast.cli.windows;

import com.eugene_andrienko.telepodcast.cli.CLIException;
import com.eugene_andrienko.youtubedl.api.YouTubeDlApi;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.GridLayout.Alignment;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoadingTitlesWindow extends AbstractWindow
{
    private final MultiWindowTextGUI cli;
    private final int numberOfThreads;
    private final Logger logger = LoggerFactory.getLogger(LoadingTitlesWindow.class);

    public LoadingTitlesWindow(MultiWindowTextGUI cli, int numberOfThreads)
    {
        this.cli = cli;
        this.numberOfThreads = numberOfThreads;
    }

    public Map<String, String> start(Set<String> urls) throws CLIException
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

        cli.addWindow(loadingTitlesWindow);
        updateScreen(cli, logger);

        Map<String, String> result = new HashMap<>();
        try(YouTubeDlApi youtube = new YouTubeDlApi(numberOfThreads))
        {
            for(String url : urls)
            {
                String title = youtube.getTitle(url);
                result.put(url, title);
                logger.debug("Processing {}, got {} title", url, title);
                progressBar.setValue(progressBar.getValue() + 1);
                cli.updateScreen();
            }
        }
        catch(IOException ex)
        {
            logger.error("Failed to instantiate youtubedl library", ex);
            new MessageDialogBuilder()
                    .setTitle("YouTube downloader error")
                    .setText("Failed to get video titles")
                    .addButton(MessageDialogButton.OK)
                    .build()
                    .showDialog(cli);
            throw new CLIException(ex);
        }
        catch(Exception ex)
        {
            logger.error("Failed to properly close youtubedl library", ex);
            new MessageDialogBuilder()
                    .setTitle("YouTube downloader error")
                    .setText("Failed to properly close resources for YouTube downloader")
                    .addButton(MessageDialogButton.OK)
                    .build()
                    .showDialog(cli);
            throw new CLIException(ex);
        }

        cli.removeWindow(loadingTitlesWindow);
        updateScreen(cli, logger);
        return result;
    }
}
