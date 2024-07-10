package com.gemail.ruannieu.components;

import com.gemail.ruannieu.eventlisteners.AddShowButtonClicked;

import javax.swing.*;
import java.awt.*;

public class AddShowButton extends JButton {

    JPanel jPanelMain;
    public AddShowButton(JPanel jPanelMain, SidePanel jPanelSide, String name){
        super(name);
        this.jPanelMain = jPanelMain;

        setAlignmentX(Component.CENTER_ALIGNMENT);
        setPreferredSize(new Dimension(300-20,50));
        setMaximumSize(new Dimension(300-20,50));
        addMouseListener(new AddShowButtonClicked(jPanelMain, jPanelSide));
    }

    /*public AddShowButton(JPanel jPanel, ImageIcon icon){
        super(icon);
        this.jPanelMain = jPanel;
        addMouseListener(new AddShowButtonClicked(jPanel));
    }

    public AddShowButton(JPanel jPanel){
        this.jPanelMain = jPanel;
        addMouseListener(new AddShowButtonClicked(jPanel));
    }*/

}
