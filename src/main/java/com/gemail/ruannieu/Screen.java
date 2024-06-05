package com.gemail.ruannieu;

import java.awt.*;

public class Screen {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final double width = screenSize.getWidth();
    private static final double height = screenSize.getHeight();

    public static double getScreenWidth(){
        return width;
    }

    public static double getScreenHeight(){
        return height;
    }
}
