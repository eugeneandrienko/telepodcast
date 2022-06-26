package com.eugene_andrienko.telepodcast.cli.windows;

import com.eugene_andrienko.telepodcast.cli.CLIException;
import com.googlecode.lanterna.gui2.BasicWindow;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.Window;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
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

    // TODO: split by words
    String formatTitle(String title)
    {
        if(title.length() <= labelSize)
        {
            return title;
        }

        int[] codePoints = title.codePoints().toArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < codePoints.length; i++)
        {
            sb.appendCodePoint(codePoints[i]);
            if(i != 0 && i % labelSize == 0)
            {
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
