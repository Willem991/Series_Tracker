package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;
import com.gemail.ruannieu.eventlisteners.FrameDragListener;

import javax.swing.*;
import java.awt.*;

public class TopRowPanel extends GradientPanel{

    public TopRowPanel(JFrame jFrame,Color[] colors, float[] fractions){
        super(colors,fractions);
        //topRowPanel.setBackground(Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        setPreferredSize(new Dimension((int) Screen.getScreenWidth(), 40));
        setMinimumSize(new Dimension((int)Screen.getScreenWidth(), 40));
        setMaximumSize(new Dimension((int)Screen.getScreenWidth(), 40));

        FrameDragListener frameDragListener = new FrameDragListener(jFrame);
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);

        MinimiseButton minimiseButton = new MinimiseButton(jFrame);
        add(minimiseButton.getMinimiseBtn());

        ExitButton exitBtn = new ExitButton();
        add(exitBtn.getExitBtn());

    }

}


