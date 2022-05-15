package com.eugene_andrienko.telepodcast;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import com.eugene_andrienko.telegram.api.TelegramApi;
import com.eugene_andrienko.telegram.api.exceptions.TelegramSendMessageException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
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

    @Parameter(names = {"-h", "--help"}, help = true)
    private boolean help;
    @Parameter(names = {"-d", "--debug"}, description = "Run application in debug mode")
    private boolean debug = false;
    @Parameter(names = "--api-id", description = "Telegram API ID", password = true, order = 0)
    private int apiId;
    @Parameter(names = "--api-hash", description = "Telegram API hash", password = true, order = 1)
    private String apiHash;

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

        try (TelegramApi telegram = new TelegramApi(apiId, apiHash, 50, debug))
        {
            telegram.login();
            if(telegram.isReady().get(60, TimeUnit.SECONDS))
            {
                logger.info("Telegram ready");
            }
            else
            {
                logger.error("Telegram is not ready");
            }
            telegram.sendMessage("TEST SUCCEED!").thenCompose(result -> {
                CompletableFuture<Boolean> res = new CompletableFuture<>();
                if(result)
                {
                    try
                    {
                        res = telegram.sendAudio(new File("/home/drag0n/downloads/Из передачи - " +
                                                          "Деревня Дураков.mp3"));
                    }
                    catch(TelegramSendMessageException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    res.complete(false);
                }
                return res;
            }).thenCompose(result -> {
                CompletableFuture<Boolean> res = new CompletableFuture<>();
                if(result)
                {
                    try
                    {
                        res = telegram.sendVideo(new File("/home/drag0n/pictures/2022-03-14 " +
                                                          "Северное сияние в Назии/" +
                                                          "lapse_scaled2.mp4"));
                    }
                    catch(TelegramSendMessageException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    res.complete(false);
                }
                return res;
            });
            Thread.sleep(15000);
        }
        catch(Exception ex)
        {
            throw new RuntimeException(ex);
        }

        getGreeting();
    }

    // TODO: delete
    private void getGreeting()
    {
        logger.debug("Debug mode enabled");
        logger.info("Hello World!");
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
