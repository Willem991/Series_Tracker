package com.gemail.ruannieu.eventlisteners;

import com.gemail.ruannieu.Screen;
import com.gemail.ruannieu.components.ShowPanel;
import com.gemail.ruannieu.components.ShowTypeSelector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddShowButtonClicked implements MouseListener {

    private int showAmount = 0;
    private int panelsPerRow;
    JPanel mainPanel;
    JPanel sidePanel;
    JFormattedTextField showTitle;
    ShowTypeSelector showType;

    public AddShowButtonClicked(JPanel mainPanel, JPanel sidepanel, ShowTypeSelector showType, JFormattedTextField showTitle){
        this.mainPanel = mainPanel;
        this.sidePanel = sidepanel;
        this.showTitle = showTitle;
        this. showType = showType;

        System.out.println(showType);
    }
    public void mouseClicked(MouseEvent e) {

        showAmount = showAmount + 1;
        panelsPerRow = mainPanel.getWidth()/300;

        JLabel showTitleLabel = new JLabel(showTitle.getText());
        JLabel showTypeLabel = new JLabel(showType.getSelectedItem().toString());

        ShowPanel showPanel = new ShowPanel();
        showPanel.add(showTitleLabel);
        showPanel.add(showTypeLabel);

        mainPanel.add(showPanel);
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
