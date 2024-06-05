package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;

public class TopRowPanel{

    JPanel topRowPanel = new JPanel();
    public TopRowPanel(){

        topRowPanel.setBackground(Color.BLACK);
        topRowPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        topRowPanel.setPreferredSize(new Dimension((int) Screen.getScreenWidth(), 40));
        topRowPanel.setMinimumSize(new Dimension((int)Screen.getScreenWidth(), 40));
        topRowPanel.setMaximumSize(new Dimension((int)Screen.getScreenWidth(), 40));

        ExitButton exitBtn = new ExitButton();
        topRowPanel.add(exitBtn.getExitBtn());

    }

    public JPanel getTopRowPanel(){
        return topRowPanel;
    }


}


