package com.gemail.ruannieu.components;

import com.gemail.ruannieu.uidesigns.CustomSplitPaneUI;

import javax.swing.*;
import java.awt.*;

public class ContainerSplitPane extends JSplitPane {

    public ContainerSplitPane(JPanel panel1, JPanel panel2, JFrame frame){
        super(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
        setOneTouchExpandable(false);
        setDividerLocation(500);
        setDividerSize(10);

        JPanel titleBar = (JPanel) panel1.getComponent(0);
        setUI(new CustomSplitPaneUI(panel1, frame));
        setBorder(null);
    }

    public ContainerSplitPane(JPanel panel1, JScrollPane panel2, JFrame frame){
        super(JSplitPane.HORIZONTAL_SPLIT, panel1, panel2);
        setOneTouchExpandable(false);
        setDividerLocation(500);
        setDividerSize(10);

        JPanel mainPanel =  (JPanel)panel2.getViewport().getView();
        setUI(new CustomSplitPaneUI(mainPanel, frame));
        setBorder(null);

    }


}
