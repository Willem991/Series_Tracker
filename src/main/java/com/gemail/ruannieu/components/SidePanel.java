package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;

public class SidePanel{

    JPanel sidePanel = new JPanel();

    public SidePanel(){

        sidePanel.setBackground(Color.BLUE);

        sidePanel.setPreferredSize(new Dimension(300, (int) Screen.getScreenHeight()));
        //sidePanel.setMinimumSize(new Dimension((int)Screen.getScreenWidth(), 50));
        //sidePanel.setMaximumSize(new Dimension((int)Screen.getScreenWidth(), 50));
    }

    public JPanel getSidePanel() {
        return sidePanel;
    }
}
