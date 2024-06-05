package com.gemail.ruannieu;

import javax.swing.*;
import com.gemail.ruannieu.Screen;
import com.gemail.ruannieu.components.MainPanel;
import com.gemail.ruannieu.components.SidePanel;
import com.gemail.ruannieu.components.TopRowPanel;
import org.w3c.dom.css.RGBColor;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        Toolkit tk = Toolkit.getDefaultToolkit();
        JFrame f = new JFrame();//creating instance of JFrame

        Image titleIcon = tk.getImage("./src/main/resources/images/icon.png");

        f.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.gridheight = 4;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.fill = GridBagConstraints.BOTH;
        TopRowPanel topRowPanel = new TopRowPanel();
        f.add(topRowPanel.getTopRowPanel(), constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 20;
        constraints.weightx = 0.3;
        constraints.weighty = 0.5;
        SidePanel sidePanel = new SidePanel();
        f.add(sidePanel.getSidePanel(), constraints);

        constraints.gridx = 2;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        constraints.gridheight = 20;
        constraints.weightx = 0.7;
        constraints.weighty = 0.5;
        MainPanel mainPanel = new MainPanel();
        f.add(mainPanel.getPanel(), constraints);

        f.setIconImage(titleIcon);
        f.setTitle("TV Show Tracker");
        f.setUndecorated(true);
        //f.setSize(600,600);
        f.setSize((int)Screen.getScreenWidth(),(int)Screen.getScreenHeight());//400 width and 500 height
        f.setLocation(((int)Screen.getScreenWidth() - f.getWidth())/2, ((int)Screen.getScreenHeight() - f.getHeight())/2);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);//making the frame visible

    }
}
