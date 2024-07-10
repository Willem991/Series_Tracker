package com.gemail.ruannieu.components;

import com.gemail.ruannieu.Screen;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.gemail.ruannieu.eventlisteners.UploadButtonClicked;

public class SidePanel extends JPanel{

    JPanel jPanelMain;

    private String imageURL;
    private String picUUID = "";
    private Image backgroundImage;
    private final ShowTypeSelector showTypeSelector;
    private final MinorShowDetailsPanel showDetailsPanel;
    private final JFormattedTextField showTitle;

    public SidePanel(JPanel jPanelMain){

        this.jPanelMain = jPanelMain;

        setBackground(new Color(59,59,59));
        setBackgroundImage(System.getProperty("user.dir") + "/images/seriesBG.png");
        setPreferredSize(new Dimension(500, (int) Screen.getScreenHeight()));
        setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));

        String[] data = {"TV Series", "Anime", "K-drama", "Cartoon", "Movie", "Short Film"};

        JLabel typeLabel = new JLabel("Select Show Type:");
        typeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        typeLabel.setForeground(Color.WHITE);
        Font labelFont = typeLabel.getFont();
        typeLabel.setFont(new Font(labelFont.getName(), labelFont.getStyle(), 16)); // Change 24 to desired font size

        showTypeSelector = new ShowTypeSelector(data);
        showTypeSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)showTypeSelector.getSelectedItem()){
                    case "TV Series":
                        imageURL = System.getProperty("user.dir") + "/images/seriesBG.png";
                        break;
                    case "Anime":
                        imageURL = System.getProperty("user.dir") + "/images/animeBG.png";
                        break;
                    case "K-drama":
                        imageURL = System.getProperty("user.dir") + "/images/kdramaBG.png";
                        break;
                    case "Cartoon":
                        imageURL = System.getProperty("user.dir") + "/images/cartoonBG.png";
                        break;
                    case "Movie":
                        imageURL = System.getProperty("user.dir") + "/images/movieBG.png";
                        break;
                    case "Short Film":
                        imageURL = System.getProperty("user.dir") + "/images/shortfilmBG.png";
                        break;
                    default:
                        System.out.println((String)showTypeSelector.getSelectedItem());
                }

                setBackgroundImage(imageURL);
            }

        });

        showTitle = new JFormattedTextField("Enter show title");
        //showTitle = new JFormattedTextField(System.getProperty("user.dir"));
        showTitle.setPreferredSize(new Dimension(300-20,30));
        showTitle.setMaximumSize(new Dimension(300-20,30));;
        showTitle.setHorizontalAlignment(SwingConstants.CENTER);
        Font font = new Font("Arial", Font.PLAIN, 15); // Example: Arial, plain, size 20
        showTitle.setFont(font);

        showDetailsPanel = new MinorShowDetailsPanel(this);

        JButton uploadImageBtn = new JButton("Upload Image");
        uploadImageBtn.addMouseListener(new UploadButtonClicked(this));

        AddShowButton addShowButton = new AddShowButton(jPanelMain, this,  "Add Show");

        TitleBar titleBar = new TitleBar(this);
        add(titleBar);
        add(Box.createVerticalStrut(20));
        add(typeLabel);
        add(Box.createVerticalStrut(3));
        add(showTypeSelector);
        add(Box.createVerticalStrut(10));
        add(showTitle);
        add(Box.createVerticalStrut(10));
        add(showDetailsPanel);
        add(Box.createVerticalStrut(10));
        add(uploadImageBtn);
        add(Box.createVerticalStrut(40));
        add(addShowButton);

    }

    public String getShowType(){
        return (String)showTypeSelector.getSelectedItem();
    }

    public String getTitle(){
        return showTitle.getText();
    }

    public String getGenre(){
        return showDetailsPanel.getGenre();
    }

    public String getAgeRating(){
        return showDetailsPanel.getAgeRating();
    }

    public String getPicUUID(){
        return picUUID;
    }

    public void setPicUUID(String value){
        this.picUUID = value;
    }

    public void setBackgroundImage(String filePath) {
        try {
            backgroundImage = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

}
