package com.eugene_andrienko.telepodcast.cli.windows;

import com.eugene_andrienko.telepodcast.TextHelper;
import com.eugene_andrienko.telepodcast.cli.CLIException;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import java.io.IOException;
import java.util.*;
import org.slf4j.Logger;


public class AbstractWindow
{
    private final int labelSize;

    public AbstractWindow()
    {
        labelSize = 40;
    }

    public AbstractWindow(int labelTextSize)
    {
        labelSize = labelTextSize;
    }

    void updateScreen(MultiWindowTextGUI cli, Logger logger) throws CLIException
    {
        try
        {
            cli.updateScreen();
        }
        catch(IOException ex)
        {
            logger.error("Failed to update screen: ", ex);
            throw new CLIException(ex);
        }
    }

    BasicWindow createCenteredWindow(String title)
    {
        BasicWindow result = new BasicWindow(title);
        Set<Window.Hint> hints = result.getHints();
        Set<Window.Hint> newHints = new HashSet<>(hints);
        newHints.add(Window.Hint.CENTERED);
        result.setHints(newHints);
        return result;
    }

    /**
     * Format video title — split by newlines if {@code title} is larger than {@code labelSize}.
     *
     * @param title Title
     *
     * @return Title, formatted with newlines.
     */
    String formatTitle(String title)
    {
        return String.join("\n", TextHelper.splitByWords(title, labelSize));
    }
}
