package com.gemail.ruannieu.eventlisteners;

import com.gemail.ruannieu.Screen;
import com.gemail.ruannieu.Tools.ConfigReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DestroyShowPane implements MouseListener {

    JPanel mainPanel;
    JPanel showPanel;

    public DestroyShowPane(JPanel showPanel, JPanel mainPanel){
        this.mainPanel = mainPanel;
        this.showPanel = showPanel;
    }

    public void mouseClicked(MouseEvent e) {

        int showAmount = ConfigReader.readRowAndShowCount() - 1;
        int panelsPerRow = mainPanel.getWidth()/300;

        ConfigReader.writeRowAndShowCount(showAmount);

        mainPanel.remove(showPanel);
        mainPanel.setPreferredSize(new Dimension((int) Screen.getScreenWidth() - 300, Math.max((int) Screen.getScreenHeight(), 500*(1+(showAmount/panelsPerRow)))));
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

}
