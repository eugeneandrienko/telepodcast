package com.eugene_andrienko.telepodcast.logging;

import java.net.URI;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.RootLoggerComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;


/**
 * {@code ConfigurationFactory} for log4j2. Disable logging.
 */
@Plugin(name = "NoneConfigurationFactory", category = ConfigurationFactory.CATEGORY)
public class NoneConfigurationFactory extends ConfigurationFactory
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
        layout.addAttribute("pattern", "%d{ISO8601} [%t] [%p] %C - %m%n");

        AppenderComponentBuilder appender = builder.newAppender("Stdout", "CONSOLE");
        appender.addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
        appender.add(layout);
        builder.add(appender);

        RootLoggerComponentBuilder rootLogger = builder.newRootLogger(Level.FATAL);
        rootLogger.add(builder.newAppenderRef("Stdout"));
        builder.add(rootLogger);

        return builder.build();
    }
}
