package com.eugene_andrienko.telepodcast;

import java.util.Properties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.slf4j.impl.SimpleLogger;
import static org.junit.jupiter.api.Assertions.*;


public class TelePodcastTest
{
    TelePodcast underTest = new TelePodcast();

    @Test
    @DisplayName("Logging with debug mode")
    void setupLoggerDebugModeTest() throws NoSuchMethodException
    {
        ReflectionUtils.invokeMethod(
                TelePodcast.class.getDeclaredMethod("setupLogger", boolean.class), underTest, true);
        Properties testProperties = System.getProperties();

        assertAll("properties", () -> {
            assertTrue(testProperties.containsKey(SimpleLogger.SHOW_DATE_TIME_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.DATE_TIME_FORMAT_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.LEVEL_IN_BRACKETS_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.DEFAULT_LOG_LEVEL_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.SHOW_THREAD_NAME_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.SHOW_LOG_NAME_KEY));
        });
        assertAll("properties values", () -> {
            assertEquals(testProperties.getProperty(SimpleLogger.SHOW_DATE_TIME_KEY), "true");
            assertEquals(testProperties.getProperty(SimpleLogger.DATE_TIME_FORMAT_KEY),
                    "yyyy-MM-dd'T'HH:mm:ssZ");
            assertEquals(testProperties.getProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY), "true");
            assertEquals(testProperties.getProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY), "debug");
            assertEquals(testProperties.getProperty(SimpleLogger.SHOW_THREAD_NAME_KEY), "true");
            assertEquals(testProperties.getProperty(SimpleLogger.SHOW_LOG_NAME_KEY), "true");
        });
    }

    @Test
    @DisplayName("Logging without debug mode")
    void setupLoggerNonDebugModeTest() throws NoSuchMethodException
    {
        ReflectionUtils.invokeMethod(
                TelePodcast.class.getDeclaredMethod("setupLogger", boolean.class),
                underTest, false);
        Properties testProperties = System.getProperties();

        assertAll("properties", () -> {
            assertTrue(testProperties.containsKey(SimpleLogger.SHOW_DATE_TIME_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.DATE_TIME_FORMAT_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.LEVEL_IN_BRACKETS_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.DEFAULT_LOG_LEVEL_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.SHOW_THREAD_NAME_KEY));
            assertTrue(testProperties.containsKey(SimpleLogger.SHOW_LOG_NAME_KEY));
        });
        assertAll("properties values", () -> {
            assertEquals(testProperties.getProperty(SimpleLogger.SHOW_DATE_TIME_KEY), "true");
            assertEquals(testProperties.getProperty(SimpleLogger.DATE_TIME_FORMAT_KEY),
                    "yyyy-MM-dd'T'HH:mm:ssZ");
            assertEquals(testProperties.getProperty(SimpleLogger.LEVEL_IN_BRACKETS_KEY), "true");
            assertEquals(testProperties.getProperty(SimpleLogger.DEFAULT_LOG_LEVEL_KEY), "info");
            assertEquals(testProperties.getProperty(SimpleLogger.SHOW_THREAD_NAME_KEY), "false");
            assertEquals(testProperties.getProperty(SimpleLogger.SHOW_LOG_NAME_KEY), "false");
        });
    }
}
