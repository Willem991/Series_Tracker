package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class TitleBar extends JPanel {

    public TitleBar(JPanel parent){

        setPreferredSize(new Dimension(parent.getWidth(), 50));
        setMinimumSize(new Dimension(500, 50));
        setMaximumSize(new Dimension((int)Screen.getScreenWidth(), 50));
        setBackground(new Color(59,59,59));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        setBorder(border);

        JLabel addShowTitle = new JLabel("Add New Show");
        addShowTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        addShowTitle.setForeground(Color.WHITE);
        Font labelFont = addShowTitle.getFont();
        addShowTitle.setFont(new Font(labelFont.getName(), labelFont.getStyle(), 27));

        add(addShowTitle);
    }

}
