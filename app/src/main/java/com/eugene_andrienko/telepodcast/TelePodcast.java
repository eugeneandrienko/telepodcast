package com.eugene_andrienko.telepodcast;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
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

    @Parameter(names = {"-h", "--help"}, help = true)
    private boolean help;
    @Parameter(names = {"-d", "--debug"}, description = "Run application in debug mode")
    private boolean debug = false;

    public static void main(String[] args)
    {
        TelePodcast podcast = new TelePodcast();

        // Parse commandline arguments:
        jCommander = JCommander.newBuilder().addObject(podcast).build();
        jCommander.parse(args);

        podcast.run();
    }

    private void run()
    {
        if(help)
        {
            showHelpMessageAndExit();
        }
        setupLogger(debug);
        logger = LoggerFactory.getLogger(TelePodcast.class);
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
