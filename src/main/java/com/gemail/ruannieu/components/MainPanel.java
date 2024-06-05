package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;

public class MainPanel{

    JPanel mainPanel = new JPanel();
    public MainPanel(){


        mainPanel.setBackground(Color.GREEN);

        mainPanel.setPreferredSize(new Dimension((int)Screen.getScreenWidth() - 300, (int) Screen.getScreenHeight()));
        //sidePanel.setMinimumSize(new Dimension((int)Screen.getScreenWidth(), 50));
        //sidePanel.setMaximumSize(new Dimension((int)Screen.getScreenWidth(), 50));

    }

    public JPanel getPanel(){
        return mainPanel;
    }

}
