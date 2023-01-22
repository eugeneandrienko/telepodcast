package com.eugene_andrienko.telepodcast;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.internal.Console;
import com.eugene_andrienko.telegram.api.TelegramApi;
import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telepodcast.cli.CLI;
import com.eugene_andrienko.telepodcast.gui.GUI;
import com.eugene_andrienko.telepodcast.logging.ConsoleConfigurationFactory;
import com.eugene_andrienko.telepodcast.logging.ConsoleDebugConfigurationFactory;
import com.eugene_andrienko.telepodcast.logging.DebugConfigurationFactory;
import com.eugene_andrienko.telepodcast.logging.NoneConfigurationFactory;
import com.eugene_andrienko.telepodcast.tui.TUI;
import com.eugene_andrienko.telepodcast.tui.TUIException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Cleanup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationFactory;


/**
 * Main class of application.
 */
@Parameters(separators = "=")
public class TelePodcast
{
    private Logger log;
    private static JCommander jCommander;
    private static final String homeDir = System.getProperty("user.home");

    @Parameter(names = {"-h", "--help"}, description = "This help message", help = true, order = 0)
    private boolean help;
    @Parameter(names = {"-d", "--debug"}, description = "Run application in debug mode", order = 2)
    private boolean debug = false;
    @Parameter(names = {"-a", "--authorize"}, description = "Authorize in Telegram via API ID " +
                                                            "and hash", order = 1)

    private boolean authorize = false;
    @Parameter(names = "--tdlib-log", description = "Path to TDLib log", order = 8)
    private String tdlibLog = "tdlib.log";
    @Parameter(names = "--tdlib-dir", description = "Path to TDLib data directory", order = 9)
    private String tdlibDir = homeDir + "/.tdlib";
    @Parameter(names = "--downloader-threads", description = "Count of threads for downloading " +
                                                             "video from YouTube", order = 7)
    private int downloaderThreads = 3;

    @Parameter(names = {"-g", "--gui"}, description = "Launch GUI", order = 3)
    private boolean launchGui = false;
    @Parameter(names = {"-t", "--tui"}, description = "Launch TUI", order = 4)
    private boolean launchTui = false;

    @Parameter(names = "--audio-urls", description = "List of URLs to download and upload as " +
                                                     "audio", variableArity = true, order = 5)
    private List<String> audioUrls = new ArrayList<>();
    @Parameter(names = "--video-urls", description = "List of URLs to download and upload as " +
                                                     "video", variableArity = true, order = 6)
    private List<String> videoUrls = new ArrayList<>();

    private int apiId = 1;
    private String apiHash = "-";

    private static final String PROGRAM_NAME = "telepodcast";

    public static void main(String[] args)
    {
        TelePodcast podcast = new TelePodcast();
        podcast.run(args);
    }

    private void run(String[] args)
    {
        // Parse commandline arguments:
        jCommander = JCommander.newBuilder().addObject(this).build();
        jCommander.setProgramName(PROGRAM_NAME);
        jCommander.parse(args);

        if(help)
        {
            showHelpMessageAndExit();
        }

        setupLogger();
        log = LogManager.getLogger(TelePodcast.class);

        if(authorize)
        {
            Console console = jCommander.getConsole();

            console.print("Telegram API ID: ");
            String apiIdStr = new String(console.readPassword(false));
            try
            {
                apiId = Integer.parseInt(apiIdStr);
            }
            catch(NumberFormatException ex)
            {
                log.error("Failed to parse provided API ID to number!");
                throw new RuntimeException("Telegram API ID not a number");
            }

            console.print("Telegram API hash: ");
            apiHash = new String(console.readPassword(false));
            if(apiHash.isEmpty())
            {
                log.error("Got empty Telegram API hash!");
                throw new RuntimeException("Empty Telegram API hash");
            }
        }

        TelegramOptions telegramOptions = new TelegramOptions(apiId, apiHash, 50, 2, 50,
                tdlibLog, tdlibDir, debug);
        log.debug("TelegramOptions:: {}", telegramOptions);

        if(authorize)
        {
            try
            {
                @Cleanup
                TelegramApi telegram = new TelegramApi(telegramOptions);
                telegram.login();
            }
            catch(TelegramInitException ex)
            {
                log.error("Failed to login to Telegram");
            }
            catch(Exception ex)
            {
                log.error("Failed to properly logout from Telegram");
            }
            return;
        }

        if(launchGui)
        {
            new GUI();
        }
        else if(launchTui)
        {
            startTUI(telegramOptions);
        }
        else
        {
            startCLI(telegramOptions);
        }
    }

    private void showHelpMessageAndExit()
    {
        jCommander.usage();
        System.exit(1);
    }

    /**
     * Setups {@code reload4j} via system properties.
     */
    private void setupLogger()
    {
        if((launchGui || launchTui) && debug)
        {
            ConfigurationFactory.setConfigurationFactory(new DebugConfigurationFactory());
        }
        else if(launchGui || launchTui)
        {
            ConfigurationFactory.setConfigurationFactory(new NoneConfigurationFactory());
        }
        else if(debug)
        {
            ConfigurationFactory.setConfigurationFactory(new ConsoleDebugConfigurationFactory());
        }
        else
        {
            ConfigurationFactory.setConfigurationFactory(new ConsoleConfigurationFactory());
        }
    }

    /**
     * Starts simple CLI.
     *
     * @param telegramOptions Initialized {@code TelegramOptions} class.
     */
    private void startCLI(TelegramOptions telegramOptions)
    {
        try
        {
            @Cleanup
            CLI cli = new CLI(telegramOptions, audioUrls, videoUrls, downloaderThreads);
            cli.start();
        }
        catch(Exception ex)
        {
            log.error("CLI fail!");
            throw new RuntimeException(ex);
        }
    }

    /**
     * Starts Terminal User Interface.
     *
     * @param telegramOptions Initialized {@code TelegramOptions} class.
     */
    private void startTUI(TelegramOptions telegramOptions)
    {
        try
        {
            @Cleanup
            TUI tui = new TUI(telegramOptions, downloaderThreads);
            tui.start();
        }
        catch(TUIException ex)
        {
            log.error("Got TUI exception: ", ex);
            throw new RuntimeException(ex);
        }
        catch(IOException ex)
        {
            log.error("Failed to start TUI!");
            throw new RuntimeException(ex);
        }
        catch(Exception ex)
        {
            log.error("Failed to stop TUI!");
            throw new RuntimeException(ex);
        }
    }
}
