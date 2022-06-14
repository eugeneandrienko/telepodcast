package com.eugene_andrienko.telepodcast;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.internal.Console;
import com.eugene_andrienko.telegram.api.TelegramApi;
import com.eugene_andrienko.telegram.api.TelegramOptions;
import com.eugene_andrienko.telegram.api.exceptions.TelegramException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.impl.SimpleLogger;


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
    private String tdlibLog = homeDir + "/tdlib.log";
    @Parameter(names = "--tdlib-dir", description = "Path to TDLib data directory")
    private String tdlibDir = homeDir + "/.tdlib";

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

        TelegramOptions telegramOptions = new TelegramOptions(apiId, apiHash, 50, 2, 30,
                tdlibLog, tdlibDir, debug);
        logger.debug("TelegramOptions:: {}", telegramOptions);
        try(TelegramApi telegram = new TelegramApi(telegramOptions))
        {
            telegram.login();
            telegram.sendMessage("TEST SUCCEED!");
        }
        catch(TelegramException ex)
        {
            logger.error("Telegram fail!", ex);
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
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
        Map<String, String> slPropsMap = new HashMap<>();
        slPropsMap.put(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        slPropsMap.put(SimpleLogger.DATE_TIME_FORMAT_KEY, "yyyy-MM-dd'T'HH:mm:ssZ");
        slPropsMap.put(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        if(isDebug)
        {
            slPropsMap.put(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
            slPropsMap.put(SimpleLogger.SHOW_THREAD_NAME_KEY, "true");
            slPropsMap.put(SimpleLogger.SHOW_LOG_NAME_KEY, "true");
        }
        else
        {
            slPropsMap.put(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "info");
            slPropsMap.put(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
            slPropsMap.put(SimpleLogger.SHOW_LOG_NAME_KEY, "false");
        }
        Properties systemProperties = System.getProperties();
        systemProperties.putAll(slPropsMap);
        System.setProperties(systemProperties);
    }
}
