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
        showHelpMessage();
        setupLogger();
        getGreeting();
    }

    private void getGreeting()
    {
        logger.debug("Debug mode enabled");
        logger.info("Hello World!");
    }

    private void showHelpMessage()
    {
        if(help)
        {
            jCommander.usage();
            System.exit(1);
        }
    }

    private void setupLogger()
    {
        Map<String, String> slPropsMap = new HashMap<>();
        slPropsMap.put(SimpleLogger.SHOW_DATE_TIME_KEY, "true");
        slPropsMap.put(SimpleLogger.DATE_TIME_FORMAT_KEY, "yyyy-MM-dd'T'HH:mm:ssZ");
        slPropsMap.put(SimpleLogger.LEVEL_IN_BRACKETS_KEY, "true");
        if(debug)
        {
            slPropsMap.put(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "debug");
        }
        else
        {
            slPropsMap.put(SimpleLogger.SHOW_THREAD_NAME_KEY, "false");
            slPropsMap.put(SimpleLogger.SHOW_LOG_NAME_KEY, "false");
        }
        Properties systemProperties = System.getProperties();
        systemProperties.putAll(slPropsMap);
        System.setProperties(systemProperties);
        logger = LoggerFactory.getLogger(TelePodcast.class);
    }
}
