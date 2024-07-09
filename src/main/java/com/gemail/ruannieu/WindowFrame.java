package com.gemail.ruannieu;

import com.gemail.ruannieu.components.*;

import javax.swing.*;
import java.awt.*;

public class WindowFrame extends JFrame{

    Toolkit tk = Toolkit.getDefaultToolkit();

    Image titleIcon = tk.getImage("./src/main/resources/images/icon.png");

    public WindowFrame(){

        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 24;
        constraints.gridheight = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.BOTH;

        Color[] colors = { new Color(59,59,59), Color.GRAY,  new Color(59,59,59) };
        float[] fractions = { 0.0f, 0.1f, 0.2f };
        TopRowPanel topRowPanel = new TopRowPanel(this, colors, fractions);
        add(topRowPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 20;
        constraints.weightx = MenuPanel.getPaneSize()/Screen.getScreenWidth();
        constraints.weighty = 0.5;
        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel, constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 22;
        constraints.gridheight = 20;
        constraints.weightx = (Screen.getScreenWidth() - MenuPanel.getPaneSize())/Screen.getScreenWidth();
        constraints.weighty = 0.5;
        MainPanel mainPanel = new MainPanel();
        SidePanel sidePanel = new SidePanel(mainPanel);

        MainScrollPanel MainScrollPane = new MainScrollPanel(mainPanel);
        MainScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        MainScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MainScrollPane.setBorder(null);

        JScrollBar verticalScrollBar = MainScrollPane.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(16);

        ContainerSplitPane containerSplitPane = new ContainerSplitPane( sidePanel, MainScrollPane, this);
        containerSplitPane.getRightComponent().setBackground(new Color(38,38,38));
        add(containerSplitPane, constraints);

        mainPanel.revalidate();
        mainPanel.repaint();

        setIconImage(titleIcon);
        setTitle("TV Show Tracker");
        setUndecorated(true);
        //f.setSize(600,600);
        setSize((int)Screen.getScreenWidth(),(int)Screen.getScreenHeight());//400 width and 500 height
        setLocation(((int)Screen.getScreenWidth() - getWidth())/2, ((int)Screen.getScreenHeight() - getHeight())/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void launchWindow(){
        setVisible(true);
    }

}
