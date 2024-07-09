package com.gemail.ruannieu.components;

import javax.swing.*;
import java.awt.*;

public class AgeSelector extends JComboBox {

    public AgeSelector(String[] data){
        super(data);

        setPreferredSize(new Dimension(40,30));
        setMaximumSize(new Dimension(40,30));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
