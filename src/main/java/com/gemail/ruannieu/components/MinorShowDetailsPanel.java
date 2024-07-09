package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;

import javax.swing.*;
import java.awt.*;

public class MinorShowDetailsPanel extends JPanel {

    private final GenreSelector genreSelector;
    private final AgeSelector ageSelector;

    public MinorShowDetailsPanel(JPanel parent){

        setPreferredSize(new Dimension(parent.getWidth(), 50));
        setMinimumSize(new Dimension(500, 30));
        setMaximumSize(new Dimension((int) Screen.getScreenWidth(), 50));
        //setBackground(new Color(59,59,59));
        setOpaque(false);
        setLayout(new FlowLayout());

        JLabel genreLabel = new JLabel("Genre: ");
        genreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        genreLabel.setForeground(Color.WHITE);
        Font labelGenreFont = genreLabel.getFont();
        genreLabel.setFont(new Font(labelGenreFont.getName(), labelGenreFont.getStyle(), 12));

        String[] genres = {"Horror", "Romantic", "Drama", "Slice of Life", "Western", "Action", "Sci-Fi", "Fantasy"};
        genreSelector = new GenreSelector(genres);

        JLabel ageLabel = new JLabel("Age rating: ");
        ageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ageLabel.setForeground(Color.WHITE);
        Font labelAgeFont = ageLabel.getFont();
        ageLabel.setFont(new Font(labelAgeFont.getName(), labelAgeFont.getStyle(), 12));

        String[] ageRatings = {"U", "PG", "PG-13", "12A", "15A", "16", "17", "18+" };
        ageSelector = new AgeSelector(ageRatings);

        add(genreLabel);
        add(genreSelector);
        add(ageLabel);
        add(ageSelector);
    }

    public String getGenre(){
        return (String)genreSelector.getSelectedItem();
    }

    public String getAgeRating(){
        return (String)ageSelector.getSelectedItem();
    }
}
