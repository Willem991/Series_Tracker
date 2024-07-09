package com.gemail.ruannieu.uidesigns;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomSplitPaneUI extends BasicSplitPaneUI {

    JPanel mainPanel;
    JFrame frame;


    public CustomSplitPaneUI(JPanel mainPanel, JFrame frame){
        this.mainPanel = mainPanel;
        this.frame = frame;
    }

    @Override
    public BasicSplitPaneDivider createDefaultDivider() {
        return new CustomDivider(this);
    }

    private static class CustomDivider extends BasicSplitPaneDivider {
        private boolean isHovered = false;

        public CustomDivider(BasicSplitPaneUI ui) {
            super(ui);
            this.setLayout(new BorderLayout());

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    isHovered = true;
                    setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    isHovered = false;
                    setCursor(Cursor.getDefaultCursor());
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (isHovered) {
                g.setColor(new Color(47,47,47));
                g.fillRect(0, 0, getWidth(), getHeight());
            }else{
                g.setColor(new Color(38,38,38));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
}