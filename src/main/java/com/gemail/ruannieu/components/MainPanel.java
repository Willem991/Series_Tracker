package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MainPanel extends JPanel implements Scrollable{

    public MainPanel(){

        setBackground(new Color(38,38,38));
        setLayout(new FlowLayout());
        setBorder(null);
        //setMaximumSize(new Dimension((int)Screen.getScreenWidth(), (int)Screen.getScreenHeight()));
        //sidePanel.setMinimumSize(new Dimension((int)Screen.getScreenWidth(), 50));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int panelsPerRow = getWidth()/300;
                int showAmount = getComponentCount();
                setPreferredSize(new Dimension(getSize().width, Math.max((int) Screen.getScreenHeight(), 500*(1+(showAmount/panelsPerRow)))));
                revalidate();
                repaint();
            }
        });

    }

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return getPreferredSize();
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 16; // Or any other value
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        return 50; // Or any other value
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return false;
    }

}
