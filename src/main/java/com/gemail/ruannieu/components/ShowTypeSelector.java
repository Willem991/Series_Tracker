package com.gemail.ruannieu.components;

import javax.swing.*;
import java.awt.*;

public class ShowTypeSelector extends JComboBox {

    public ShowTypeSelector(String[] data){
        super(data);

        setPreferredSize(new Dimension(300 - 20,30));
        setMaximumSize(new Dimension(300 - 20,30));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
