package com.eugene_andrienko.telepodcast.tui.windows;

import com.eugene_andrienko.telepodcast.tui.DownloadOptions;
import com.eugene_andrienko.telepodcast.tui.DownloadOptions.DownloadType;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.GridLayout.Alignment;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SelectDownloadsWindow extends AbstractWindow
{
    private final MultiWindowTextGUI tui;

    public SelectDownloadsWindow(MultiWindowTextGUI tui)
    {
        super();
        this.tui = tui;
    }

    public List<DownloadOptions> start(Map<String, String> videoTitles)
    {
        List<DownloadOptions> result = new LinkedList<>();

        Panel dataPanel = new Panel();
        dataPanel.setLayoutManager(new GridLayout(3).setLeftMarginSize(1).setRightMarginSize(1))
                 .setLayoutData(GridLayout.createLayoutData(
                         Alignment.BEGINNING, Alignment.FILL, true, true));

        BasicWindow window = createCenteredWindow("Select what to download and how:");
        window.setComponent(dataPanel);

        // Add heading of table:
        dataPanel.addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new Label("Download?").addStyle(SGR.BOLD))
                 .addComponent(new Label("Title").addStyle(SGR.BOLD))
                 .addComponent(new Label("File type").addStyle(SGR.BOLD))
                 .addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new EmptySpace(TerminalSize.ONE))
                 .addComponent(new EmptySpace(TerminalSize.ONE));

        // Add elements - video title and controls:
        for(Map.Entry<String, String> title : videoTitles.entrySet())
        {
            DownloadOptions option = DownloadOptions.builder()
                                                    .url(title.getKey())
                                                    .title(title.getValue())
                                                    .downloadType(DownloadType.AUDIO)
                                                    .isDownload(true)
                                                    .build();
            result.add(option);

            CheckBox checkBox = new CheckBox();
            checkBox.setChecked(option.isDownload())
                    .addListener(option::setDownload);

            ComboBox<String> comboBoxList = new ComboBox<String>();
            for(DownloadType downloadType : DownloadType.values())
            {
                comboBoxList.addItem(downloadType.toString());
            }
            comboBoxList.addListener((selectedIndex, previousSelection, changedByUser) -> {
                            option.setDownloadType(DownloadType.get(selectedIndex));
                        })
                        .setSelectedIndex(option.getDownloadType().ordinal());

            dataPanel.addComponent(checkBox)
                     .addComponent(new Label(formatTitle(title.getValue())))
                     .addComponent(comboBoxList);
        }

        // Add action button:
        Panel buttonPanel = new Panel();
        buttonPanel.setLayoutManager(new GridLayout(1).setHorizontalSpacing(1))
                   .setLayoutData(GridLayout.createLayoutData(
                           Alignment.CENTER, Alignment.CENTER, true, true))
                   .addComponent(new EmptySpace(TerminalSize.ONE))
                   .addComponent(new Button("Download", () -> {
                       result.removeIf(element -> {
                           if(!element.isDownload())
                           {
                               log.debug("User selected not to download {}", element.getUrl());
                           }
                           return !element.isDownload();
                       });
                       window.close();
                   }));
        dataPanel.addComponent(new EmptySpace(TerminalSize.ZERO))
                 .addComponent(buttonPanel)
                 .addComponent(new EmptySpace(TerminalSize.ZERO));

        // Wait while the window not closed by button
        tui.addWindowAndWait(window);
        return result;
    }
}
