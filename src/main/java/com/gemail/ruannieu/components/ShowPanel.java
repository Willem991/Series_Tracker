package com.gemail.ruannieu.components;

import javax.swing.*;
import java.awt.*;

public class ShowPanel extends JPanel {


    public ShowPanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 500));
        setBackground(Color.WHITE);
    }
}
