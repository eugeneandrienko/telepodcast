package com.eugene_andrienko.telepodcast.tui.windows;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.eugene_andrienko.telepodcast.helpers.SimpleTextHelper.removeInvalidUrls;


public class EnterLinksWindow
{
    private final Logger logger = LoggerFactory.getLogger(EnterLinksWindow.class);
    private final MultiWindowTextGUI tui;

    public EnterLinksWindow(MultiWindowTextGUI tui)
    {
        this.tui = tui;
    }

    public Set<String> start()
    {
        Set<String> urls = new HashSet<>();

        while(urls.isEmpty())
        {
            String input = new TextInputDialogBuilder()
                    .setTitle("Enter YouTube links to download:")
                    .setTextBoxSize(new TerminalSize(80, 20))
                    .build()
                    .showDialog(tui);

            if(input == null || input.isEmpty())
            {
                logger.error("Got empty string from user");
                return urls;
            }

            urls = parseUrlsToList(input);
            if(urls.isEmpty())
            {
                logger.error("After parsing - got empty list of links, from input: {}", input);
                new MessageDialogBuilder()
                        .setTitle("Error")
                        .setText("No URLs provided!")
                        .addButton(MessageDialogButton.OK)
                        .build()
                        .showDialog(tui);
            }

            urls = removeInvalidUrls(urls);
            if(urls.isEmpty())
            {
                logger.error("No one link are for YouTube");
                new MessageDialogBuilder()
                        .setTitle("Error")
                        .setText("No valid URLs provided!")
                        .addButton(MessageDialogButton.OK)
                        .build()
                        .showDialog(tui);
            }
        }

        return urls;
    }

    private Set<String> parseUrlsToList(String urls)
    {
        String[] data = urls.split(System.lineSeparator());
        logger.debug("Got {} data elements after split by line separator", data.length);
        Set<String> result = new HashSet<>();
        Collections.addAll(result, data);
        logger.debug("Got {} unique data elements", result.size());
        return result;
    }
}
