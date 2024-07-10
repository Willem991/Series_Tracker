package com.gemail.ruannieu.eventlisteners;

import com.gemail.ruannieu.components.SidePanel;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UploadButtonClicked implements MouseListener {

    SidePanel sidePanel;
    public UploadButtonClicked(SidePanel sidePanel){
        this.sidePanel = sidePanel;
    }
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".jpg")
                        || f.getName().toLowerCase().endsWith(".jpeg")
                        || f.getName().toLowerCase().endsWith(".png")
                        || f.getName().toLowerCase().endsWith(".gif");
            }

            @Override
            public String getDescription() {
                return "Image Files (*.jpg, *.jpeg, *.png, *.gif)";
            }
        });

        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            Path destinationDir = Paths.get("./images/shows"); // Specify your directory here
            try {
                if (!Files.exists(destinationDir)) {
                    Files.createDirectories(destinationDir);
                }
                UUID uuid = UUID.randomUUID();

                String fileName = selectedFile.getName();
                String filePath = (uuid + fileName.substring(fileName.lastIndexOf(".")));

                sidePanel.setPicUUID(filePath);
                Path destinationPath = destinationDir.resolve(filePath);
                Files.copy(selectedFile.toPath(), destinationPath);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    public void mousePressed(MouseEvent e) {
    }
    public void mouseReleased(MouseEvent e) {
    }
    public void mouseEntered(MouseEvent e) {
    }
    public void mouseExited(MouseEvent e) {
    }
}
