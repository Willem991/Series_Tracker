package com.gemail.ruannieu.Tools;

import com.gemail.ruannieu.Screen;
import com.gemail.ruannieu.components.ShowPanel;
import com.gemail.ruannieu.components.ShowTypeSelector;
import com.gemail.ruannieu.components.SidePanel;
import com.gemail.ruannieu.eventlisteners.DestroyShowPane;
import com.gemail.ruannieu.eventlisteners.AddShowButtonClicked;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ShowPaneCreator {

    private int showAmount;
    private int panelsPerRow;
    JPanel mainPanel;
    SidePanel sidePanel;
    UUID uuid;

    public ShowPaneCreator(JPanel mainPanel, SidePanel sidePanel, AddShowButtonClicked addShowButtonClicked){
        this.mainPanel = mainPanel;
        this.sidePanel = sidePanel;
        this.showAmount = addShowButtonClicked.getShowAmount();
        this.panelsPerRow = addShowButtonClicked.getPanelsPerRow();
        uuid = UUID.randomUUID();
    }

    public void createShowPanel(){

        JLabel showTitleLabel = new JLabel(sidePanel.getTitle());
        showTitleLabel.setForeground(Color.white);
        showTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel showTypeLabel = new JLabel(sidePanel.getShowType());
        showTypeLabel.setForeground(Color.white);

        JLabel showGenreLabel = new JLabel(sidePanel.getGenre());
        showGenreLabel.setForeground(Color.white);

        JLabel showAgeLabel = new JLabel(sidePanel.getAgeRating());
        showAgeLabel.setForeground(Color.white);

        JButton deleteShowPaneBtn = new JButton("Delete Entry");

        ShowPanel showPanel = new ShowPanel();

        deleteShowPaneBtn.addMouseListener(new DestroyShowPane(showPanel, mainPanel));

        showPanel.add(showTitleLabel);
        showPanel.add(showTypeLabel);
        showPanel.add(showGenreLabel);
        showPanel.add(showAgeLabel);
        showPanel.add(deleteShowPaneBtn);

        if (!sidePanel.getPicUUID().equals("")){
            System.out.println("./images/shows/" + sidePanel.getPicUUID());
            showPanel.setBackgroundImage("./images/shows/" + sidePanel.getPicUUID());
            sidePanel.setPicUUID("");
        }

        mainPanel.add(showPanel);
        mainPanel.setPreferredSize(new Dimension((int) Screen.getScreenWidth() - 300, Math.max((int) Screen.getScreenHeight(), 500*(1+(showAmount/panelsPerRow)))));
        mainPanel.revalidate();
        mainPanel.repaint();
    }

}
