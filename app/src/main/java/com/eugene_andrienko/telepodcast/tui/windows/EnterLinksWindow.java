package com.eugene_andrienko.telepodcast.tui.windows;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import static com.eugene_andrienko.telepodcast.helpers.SimpleTextHelper.removeInvalidUrls;


@Slf4j
public class EnterLinksWindow
{
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
                log.error("Got empty string from user");
                return urls;
            }

            urls = parseUrlsToList(input);
            if(urls.isEmpty())
            {
                log.error("After parsing - got empty list of links, from input: {}", input);
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
                log.error("No one link are for YouTube");
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
        log.debug("Got {} data elements after split by line separator", data.length);
        Set<String> result = new HashSet<>();
        Collections.addAll(result, data);
        log.debug("Got {} unique data elements", result.size());
        return result;
    }
}
