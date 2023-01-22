package com.eugene_andrienko.telepodcast.logging;

import java.net.URI;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Filter.Result;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;


/**
 * {@code ConfigurationFactory} for log4j2. Prints an ordinary log to console.
 */
@Plugin(name = "ConsoleConfigurationFactory", category = ConfigurationFactory.CATEGORY)
public class ConsoleConfigurationFactory extends ConfigurationFactory
{
    @Override
    protected String[] getSupportedTypes()
    {
        return new String[]{"*"};
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final String name,
            final URI configLocation, final ClassLoader loader)
    {
        ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
        return createConfiguration(name, builder);
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext,
            final ConfigurationSource source)
    {
        return this.getConfiguration(null, source.toString(), null, null);
    }

    static Configuration createConfiguration(final String name,
            ConfigurationBuilder<BuiltConfiguration> builder)
    {
        builder.setConfigurationName(name);
        builder.setStatusLevel(Level.ERROR);

        LayoutComponentBuilder layout = builder.newLayout("PatternLayout");
        layout.addAttribute("pattern", "%d{ABSOLUTE} [%p] %c{1} - %m%n");

        String filterRegex = ".*Nothing to split.*|" +
                             ".*Fail to split string by words*.|" +
                             ".*Logout completed.*|" +
                             ".*Logging out from Telegram.*";
        FilterComponentBuilder filter = builder.newFilter("RegexFilter", Result.DENY,
                Result.ACCEPT);
        filter.addAttribute("regex", filterRegex);

        AppenderComponentBuilder appender = builder.newAppender("Stdout", "CONSOLE");
        appender.addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
        appender.add(layout);
        appender.add(filter);
        builder.add(appender);

        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.INFO);
        rootLogger.add(builder.newAppenderRef("Stdout"));
        builder.add(rootLogger);

        return builder.build();
    }
}
