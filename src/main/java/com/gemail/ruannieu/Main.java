package com.gemail.ruannieu;

import com.gemail.ruannieu.Tools.ExtractResources;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            ExtractResources.extractFolder("./", "images");
        }catch (IOException | URISyntaxException e){
            System.out.println(e);
        }
        WindowFrame windowFrame = new WindowFrame();
        windowFrame.launchWindow();

    }


}
