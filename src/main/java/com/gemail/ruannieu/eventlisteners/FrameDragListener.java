package com.gemail.ruannieu.eventlisteners;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrameDragListener extends MouseAdapter {

    private final JFrame frame;
    private Point mouseDownCompCoords = null;

    public FrameDragListener(JFrame frame) {
        this.frame = frame;
    }

    public void mouseReleased(MouseEvent e) {
        mouseDownCompCoords = null;

        Point currCoords = e.getLocationOnScreen();

        System.out.println(currCoords.getX());

        if(currCoords.getY() <= 1 ){
            frame.setSize((int)Screen.getScreenWidth(), (int)Screen.getScreenHeight());
            frame.setLocation(0,0);
        }else if(currCoords.getX() <= 1){
            frame.setSize((int)(Screen.getScreenWidth()/2), (int)Screen.getScreenHeight());
            frame.setLocation(0,0);
        }else if(currCoords.getX() >= (Screen.getScreenWidth() - 3)){
            frame.setSize((int)(Screen.getScreenWidth()/2), (int)Screen.getScreenHeight());
            frame.setLocation((int)Screen.getScreenWidth()/2,0);
        }
    }

    public void mousePressed(MouseEvent e) {
        mouseDownCompCoords = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {
        Point currCoords = e.getLocationOnScreen();
        frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);


    }
}
