package com.eugene_andrienko.telepodcast.tui.components;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.ThemeDefinition;
import com.googlecode.lanterna.gui2.ProgressBar;
import com.googlecode.lanterna.gui2.TextGUIGraphics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Progress bar with "busy waiting" mode.
 */
public class ImprovedProgressBar extends ProgressBar
{
    private final AtomicInteger waitingCursorPos = new AtomicInteger();
    private ExecutorService executor;
    private final long speed;

    public ImprovedProgressBar(int min, int max, int preferredWidth)
    {
        super(min, max, preferredWidth);
        waitingCursorPos.set(-1);
        speed = 100;
        this.setRenderer(new ImprovedProgressBarRenderrer());
    }

    @Override
    public synchronized ProgressBar setValue(final int value)
    {
        if(waitingCursorPos.get() >= 0)
        {
            waitingCursorPos.set(-1);
            executor.shutdown();
        }

        this.setVisible(true);
        return super.setValue(value);
    }

    public synchronized void busyWaiting()
    {
        this.setVisible(true);
        if(waitingCursorPos.get() < 0)
        {
            waitingCursorPos.set(0);
            executor = Executors.newSingleThreadExecutor();
            executor.execute(() ->
            {
                while(true)
                {
                    if(waitingCursorPos.get() < 0)
                    {
                        return;
                    }

                    int position = this.waitingCursorPos.incrementAndGet();
                    if(position > 100)
                    {
                        this.waitingCursorPos.set(0);
                    }

                    try
                    {
                        //noinspection BusyWait
                        Thread.sleep(speed);
                    }
                    catch(InterruptedException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            });
        };
    }

    public synchronized void hide()
    {
        if(waitingCursorPos.get() >= 0)
        {
            waitingCursorPos.set(-1);
            executor.shutdown();
        }

        this.setVisible(false);
    }

    public class ImprovedProgressBarRenderrer extends DefaultProgressBarRenderer
    {
        @Override
        public void drawComponent(final TextGUIGraphics graphics, final ProgressBar component)
        {
            int waitingPos = waitingCursorPos.get();
            if(waitingPos >= 0)
            {
                TerminalSize size = graphics.getSize();
                if(size.getRows() == 0 || size.getColumns() == 0)
                {
                    return;
                }
                ThemeDefinition themeDefinition = component.getThemeDefinition();
                int columnOfProgress = (int)(waitingPos / 100.0 * size.getColumns());
                char filler = themeDefinition.getCharacter("FILLER", ' ');

                for(int row = 0; row < size.getRows(); row++)
                {
                    for(int column = 0; column < size.getColumns(); column++)
                    {
                        if(column == columnOfProgress)
                        {
                            graphics.applyThemeStyle(themeDefinition.getActive());
                        }
                        else
                        {
                            graphics.applyThemeStyle(themeDefinition.getNormal());
                        }
                        graphics.setCharacter(column, row, filler);
                    }
                }
            }
            else
            {
                super.drawComponent(graphics, component);
            }
        }
    }
}
