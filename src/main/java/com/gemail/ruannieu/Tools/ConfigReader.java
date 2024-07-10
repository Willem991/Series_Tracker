package com.gemail.ruannieu.Tools;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class ConfigReader {

   public static int readRowAndShowCount(){

       Path path = Paths.get("config.txt");

       int show_count = 0;

       if (Files.exists(path)) {
           try {
               List<String> lines = Files.readAllLines(path);
                show_count = Integer.parseInt(lines.get(1));
           } catch (IOException e) {
               e.printStackTrace();
           }
       } else {
           // Create the file if it does not exist
           try {
               Files.createFile(path);
               System.out.println("File created: " + path.toString());
           } catch (IOException e) {
               System.err.println("Failed to create file: " + e.getMessage());
           }
       }

       return show_count;
   }

    public static void writeRowAndShowCount( int show_count){
        Path path = Paths.get("config.txt");
        List<String> lines = Arrays.asList( "show count", String.valueOf(show_count));
        try {
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
