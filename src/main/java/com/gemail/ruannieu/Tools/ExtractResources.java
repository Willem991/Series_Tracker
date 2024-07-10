package com.gemail.ruannieu.Tools;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.jar.JarEntry;


public class ExtractResources {
    public static void extractFolder(String outputDirPath, String folderToExtract) throws IOException, URISyntaxException {
        // Get the path to the JAR file
        Path jarFilePath = Paths.get(System.getProperty("user.dir") + "\\Series_Tracker-application.jar");


        // Create output directory if it does not exist
        File outputDir = new File(outputDirPath);
        if (!outputDir.exists()) {
            outputDir.mkdirs();
        }

        JarFile jarFile = new JarFile(jarFilePath.toFile());

        Enumeration<JarEntry> entries = jarFile.entries();
        while (entries.hasMoreElements()) {
            JarEntry entry = entries.nextElement();
            // Check if the entry is within the folder to extract
            if (entry.getName().startsWith(folderToExtract + "/") || entry.getName().equals(folderToExtract)) {
                File entryFile = new File(outputDirPath, entry.getName());
                if (entry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    // Create parent directories if necessary
                    File parentDir = entryFile.getParentFile();
                    if (!parentDir.exists()) {
                        parentDir.mkdirs();
                    }

                    // Extract file
                    InputStream is = jarFile.getInputStream(entry);
                    FileOutputStream os = new FileOutputStream(entryFile);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = is.read(buffer)) != -1) {
                        os.write(buffer, 0, bytesRead);
                    }
                    is.close();
                    os.close();
                }
            }
        }
        jarFile.close();
    }
}

