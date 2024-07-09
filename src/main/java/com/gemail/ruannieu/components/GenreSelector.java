package com.gemail.ruannieu.components;

import javax.swing.*;
import java.awt.*;

public class GenreSelector extends JComboBox {

    public GenreSelector(String[] data){
        super(data);

        setPreferredSize(new Dimension(300 - 200,30));
        setMaximumSize(new Dimension(300 - 200,30));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
