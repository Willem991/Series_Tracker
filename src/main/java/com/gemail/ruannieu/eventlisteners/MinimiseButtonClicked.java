package com.gemail.ruannieu.eventlisteners;

import com.gemail.ruannieu.WindowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MinimiseButtonClicked implements MouseListener {

    JFrame jFrame;

    public MinimiseButtonClicked(JFrame jFrame){
        this.jFrame = jFrame;
    }

    public void mouseClicked(MouseEvent e) {

        jFrame.setState(Frame.ICONIFIED);
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
