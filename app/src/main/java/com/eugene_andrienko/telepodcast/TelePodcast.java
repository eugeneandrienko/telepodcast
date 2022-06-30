package com.eugene_andrienko.telepodcast;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.internal.Console;
import com.eugene_andrienko.telegram.api.TelegramApi;
import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.TelegramInitException;
import com.eugene_andrienko.telepodcast.tui.TUI;
import com.eugene_andrienko.telepodcast.tui.TUIException;
import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Main class of application.
 */
@Parameters(separators = "=")
public class TelePodcast
{
    private Logger logger;
    private static JCommander jCommander;
    private static final String homeDir = System.getProperty("user.home");

    @Parameter(names = {"-h", "--help"}, help = true)
    private boolean help;
    @Parameter(names = {"-d", "--debug"}, description = "Run application in debug mode")
    private boolean debug = false;
    @Parameter(names = {"-a", "--authorize"}, description = "Authorize in Telegram via API ID " +
                                                            "and hash")

    private boolean authorize = false;
    @Parameter(names = "--tdlib-log", description = "Path to TDLib log")
    private String tdlibLog = "tdlib.log";
    @Parameter(names = "--tdlib-dir", description = "Path to TDLib data directory")
    private String tdlibDir = homeDir + "/.tdlib";
    @Parameter(names = {"-t", "--downloader-threads"}, description = "Count of threads for " +
                                                                     "downloading video from " +
                                                                     "YouTube")
    private int downloaderThreads = 3;

    @Parameter(names = {"-g", "--gui"}, description = "Launch GUI insted of curses-like interface")
    private boolean launchGui = false;

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

        setupLogger(debug);
        logger = LoggerFactory.getLogger(TelePodcast.class);

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
                logger.error("Failed to parse provided API ID to number!");
                throw new RuntimeException("Telegram API ID not a number");
            }

            console.print("Telegram API hash: ");
            apiHash = new String(console.readPassword(false));
            if(apiHash.isEmpty())
            {
                logger.error("Got empty Telegram API hash!");
                throw new RuntimeException("Empty Telegram API hash");
            }
        }

        TelegramOptions telegramOptions = new TelegramOptions(apiId, apiHash, 50, 2, 50,
                tdlibLog, tdlibDir, debug);
        logger.debug("TelegramOptions:: {}", telegramOptions);

        if(authorize)
        {
            try(TelegramApi telegram = new TelegramApi(telegramOptions))
            {
                telegram.login();
            }
            catch(TelegramInitException ex)
            {
                logger.error("Failed to login to Telegram");
            }
            catch(Exception ex)
            {
                logger.error("Failed to properly logout from Telegram");
            }
            return;
        }

        if(launchGui)
        {
            new GUI();
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
     * Setups {@code SimpleLogger} via system properties.
     *
     * @param isDebug Use debug print settings if true.
     */
    private void setupLogger(boolean isDebug)
    {
        final String DEBUG_PROPERTIES = "/log4j-debug.properties";
        final String NOLOG_PROPERTIES = "/log4j-none.properties";
        PropertyConfigurator.configure(TelePodcast.class.getResource(
                isDebug ? DEBUG_PROPERTIES : NOLOG_PROPERTIES));
    }

    private void startCLI(TelegramOptions telegramOptions)
    {
        try(TUI cli = new TUI(telegramOptions, downloaderThreads))
        {

            cli.start();
        }
        catch(TUIException ex)
        {
            logger.error("Got TUI exception: ", ex);
            throw new RuntimeException(ex);
        }
        catch(IOException ex)
        {
            logger.error("Failed to start TUI!");
            throw new RuntimeException(ex);
        }
        catch(Exception ex)
        {
            logger.error("Failed to stop TUI!");
            throw new RuntimeException(ex);
        }
    }
}
