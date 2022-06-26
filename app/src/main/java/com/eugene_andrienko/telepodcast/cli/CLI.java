package com.eugene_andrienko.telepodcast.cli;

import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telepodcast.cli.windows.DownloadWindow;
import com.eugene_andrienko.telepodcast.cli.windows.EnterLinksWindow;
import com.eugene_andrienko.telepodcast.cli.windows.LoadingTitlesWindow;
import com.eugene_andrienko.telepodcast.cli.windows.SelectDownloadsWindow;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CLI implements AutoCloseable
{
    private final Logger logger = LoggerFactory.getLogger(CLI.class);

    private final TelegramOptions telegramOptions;
    private final int downloaderThreads;
    private final Screen screen;
    private final MultiWindowTextGUI cli;

    private final static String title = CLI.class.getPackage().getImplementationTitle();
    private final static String version = CLI.class.getPackage().getImplementationVersion();

    public CLI(TelegramOptions telegramOptions, int downloaderThreads) throws IOException
    {
        this.telegramOptions = telegramOptions;
        this.downloaderThreads = downloaderThreads;

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        cli = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
                new EmptySpace(TextColor.ANSI.BLUE));

        Label titleLabel = new Label(title + " " + version)
                .setForegroundColor(TextColor.ANSI.WHITE)
                .setBackgroundColor(TextColor.ANSI.BLUE);
        BasicWindow titleWindow = new BasicWindow();
        titleWindow.setHints(Arrays.asList(Window.Hint.NO_DECORATIONS, Window.Hint.NO_FOCUS,
                Window.Hint.NO_POST_RENDERING));
        titleWindow.setComponent(titleLabel);
        cli.addWindow(titleWindow)
           .updateScreen();
    }

    public void start() throws CLIException
    {
        Set<String> urls = new EnterLinksWindow(cli).start();
        if(urls.isEmpty())
        {
            return;
        }

        Map<String, String> urlTitleMap = new LoadingTitlesWindow(cli, downloaderThreads)
                .start(urls);
        List<DownloadOptions> downloadOptions = new SelectDownloadsWindow(cli)
                .start(urlTitleMap);

        new DownloadWindow(cli, telegramOptions, downloaderThreads)
                .start(downloadOptions);
    }

    @Override
    public void close() throws Exception
    {
        screen.stopScreen();
    }
}
