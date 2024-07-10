package com.gemail.ruannieu.eventlisteners;

import com.gemail.ruannieu.Screen;
import com.gemail.ruannieu.Tools.ConfigReader;
import com.gemail.ruannieu.Tools.ShowPaneCreator;
import com.gemail.ruannieu.components.ShowPanel;
import com.gemail.ruannieu.components.ShowTypeSelector;
import com.gemail.ruannieu.components.SidePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddShowButtonClicked implements MouseListener {

    private int showAmount = 0;
    private int panelsPerRow;
    JPanel mainPanel;
    SidePanel sidePanel;

    public AddShowButtonClicked(JPanel mainPanel, SidePanel sidePanel){
        this.mainPanel = mainPanel;
        this.sidePanel = sidePanel;

    }
    public void mouseClicked(MouseEvent e) {

        //showAmount = showAmount + 1;
        showAmount = ConfigReader.readRowAndShowCount() + 1;
        panelsPerRow = mainPanel.getWidth()/300;

        ConfigReader.writeRowAndShowCount(showAmount);


        ShowPaneCreator showPanelCreator = new ShowPaneCreator(mainPanel, sidePanel, this);

        showPanelCreator.createShowPanel();
    }

    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }

    public int getShowAmount(){
        return showAmount;
    }

    public int getPanelsPerRow(){
        return panelsPerRow;
    }
}
