package com.gemail.ruannieu.components;

import com.gemail.ruannieu.eventlisteners.ExitButtonClicked;

import javax.swing.*;
import java.awt.*;

public class ExitButton {

    Icon icon = new ImageIcon("./src/main/resources/images/close.png");
    JButton exitBtn =  new JButton(icon);

    public ExitButton(){

        exitBtn.setPreferredSize(new Dimension(30, 30));
        exitBtn.addMouseListener(new ExitButtonClicked());
    }

    public JButton getExitBtn() {
        return exitBtn;
    }
}
