package com.eugene_andrienko.telepodcast.tui;

import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telepodcast.tui.windows.DownloadWindow;
import com.eugene_andrienko.telepodcast.tui.windows.EnterLinksWindow;
import com.eugene_andrienko.telepodcast.tui.windows.LoadingTitlesWindow;
import com.eugene_andrienko.telepodcast.tui.windows.SelectDownloadsWindow;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TUI implements AutoCloseable
{
    private final TelegramOptions telegramOptions;
    private final int downloaderThreads;
    private final Screen screen;
    private final MultiWindowTextGUI tui;

    private final static String title = TUI.class.getPackage().getImplementationTitle();
    private final static String version = TUI.class.getPackage().getImplementationVersion();

    public TUI(TelegramOptions telegramOptions, int downloaderThreads) throws IOException
    {
        this.telegramOptions = telegramOptions;
        this.downloaderThreads = downloaderThreads;

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();
        tui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
                new EmptySpace(TextColor.ANSI.BLUE));

        Label titleLabel = new Label(title + " " + version)
                .setForegroundColor(TextColor.ANSI.WHITE)
                .setBackgroundColor(TextColor.ANSI.BLUE);
        BasicWindow titleWindow = new BasicWindow();
        titleWindow.setHints(Arrays.asList(Window.Hint.NO_DECORATIONS, Window.Hint.NO_FOCUS,
                Window.Hint.NO_POST_RENDERING));
        titleWindow.setComponent(titleLabel);
        tui.addWindow(titleWindow)
           .updateScreen();
    }

    public void start() throws TUIException
    {
        Set<String> urls = new EnterLinksWindow(tui).start();
        if(urls.isEmpty())
        {
            return;
        }

        Map<String, String> urlTitleMap = new LoadingTitlesWindow(tui, downloaderThreads)
                .start(urls);
        List<DownloadOptions> downloadOptions = new SelectDownloadsWindow(tui)
                .start(urlTitleMap);

        new DownloadWindow(tui, telegramOptions, downloaderThreads)
                .start(downloadOptions);
    }

    @Override
    public void close() throws Exception
    {
        screen.stopScreen();
    }
}
