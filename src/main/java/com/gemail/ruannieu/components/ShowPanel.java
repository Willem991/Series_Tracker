package com.gemail.ruannieu.components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ShowPanel extends JPanel {


    private Image backgroundImage;

    public ShowPanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 500));
        setBackground(new Color(38,38,38));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        // Set the shadow color and position
        Color shadowColor = new Color(100, 100, 100, 70);
        int shadowSize = 10;
        int xOffset = 5;
        int yOffset = 5;

        // Draw the shadow
        g2d.setColor(shadowColor);
        g2d.fillRoundRect(xOffset, yOffset, getWidth() - shadowSize, getHeight() - shadowSize, 15, 15);

        // Draw the panel background
        g2d.setColor(new Color(50, 50, 50));
        g2d.fillRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, 15, 15);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth() - shadowSize, this.getHeight() - shadowSize, this);
        }

        // Draw the panel border
        g2d.setColor(Color.BLACK);
        g2d.drawRoundRect(0, 0, getWidth() - shadowSize, getHeight() - shadowSize, 15, 15);

        g2d.dispose();
    }

    public void setBackgroundImage(String filePath) {
        try {
            backgroundImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }
    }
}
