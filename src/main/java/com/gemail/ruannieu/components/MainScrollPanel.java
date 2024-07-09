package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;

public class MainScrollPanel extends JScrollPane {

    public MainScrollPanel(JPanel mainPanel){
        super(mainPanel);
        setBackground(new Color(38,38,38));
    }
}
