package com.eugene_andrienko.telepodcast.cli.components;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.DialogWindow;
import java.util.HashSet;
import java.util.Set;


public class CenteredWaitingDialog extends DialogWindow
{
    private CenteredWaitingDialog(String title, String text)
    {
        super(title);
        Panel mainPanel = Panels.horizontal(
                new Label(text),
                AnimatedLabel.createClassicSpinningLine());
        setComponent(mainPanel);

        Set<Hint> unmodifiableHints = getHints();
        Set<Hint> newHints = new HashSet<>(unmodifiableHints);
        newHints.add(Hint.CENTERED);
        setHints(newHints);
    }

    public void showDialog(WindowBasedTextGUI textGUI, boolean blockUntilClosed)
    {
        textGUI.addWindow(this);
        if(blockUntilClosed)
        {
            // Wait for the window to close, in case the window manager doesn't honor the MODAL hint
            waitUntilClosed();
        }
    }

    public static CenteredWaitingDialog showDialog(WindowBasedTextGUI textGUI, String title,
            String text)
    {
        CenteredWaitingDialog waitingDialog = new CenteredWaitingDialog(title, text);
        waitingDialog.showDialog(textGUI, false);
        return waitingDialog;
    }
}
