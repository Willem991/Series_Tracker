package com.gemail.ruannieu.components;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GradientPanel extends JPanel {

    private Color[] colors;
    private float[] fractions;

    public GradientPanel(Color[] colors, float[] fractions) {
        this.colors = colors;
        this.fractions = fractions;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Create a LinearGradientPaint with multiple colors
        LinearGradientPaint gradientPaint = new LinearGradientPaint(
                new Point2D.Float(0, 0), new Point2D.Float(width, height),
                fractions, colors
        );
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height);
    }

}
