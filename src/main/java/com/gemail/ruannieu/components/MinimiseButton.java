package com.gemail.ruannieu.components;

import com.gemail.ruannieu.eventlisteners.MinimiseButtonClicked;

import javax.swing.*;
import java.awt.*;

public class MinimiseButton {

    JButton minimiseBtn = new JButton("minimise");

    public MinimiseButton(JFrame jFrame){

        minimiseBtn.setPreferredSize(new Dimension(30, 30));
        minimiseBtn.addMouseListener(new MinimiseButtonClicked(jFrame));
    }

    public JButton getMinimiseBtn(){
        return minimiseBtn;
    }
}
