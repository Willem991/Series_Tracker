package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPanel extends JPanel {

    private static final int paneSize = 30;
    public MenuPanel(){

        setPreferredSize(new Dimension(paneSize, (int)Screen.getScreenHeight()));
        setMinimumSize(new Dimension(paneSize, (int)Screen.getScreenHeight()));
        setMaximumSize(new Dimension(paneSize, (int)Screen.getScreenHeight()));
        setBackground(new Color(59,59,59));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);
    }

    public static int getPaneSize(){
        return paneSize;
    }
}
