package com.vat.data;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Date;

public class DataTestBase {

    ArrayList<String> createdFiles = new ArrayList<>();

    static String generateFileLocation(String name, String extension) {
        String path = FileSystems.getDefault().getPath(".")
                .toAbsolutePath()
                .toString();
        StringBuilder builder = new StringBuilder(path);
        // removing last character from String
        builder.deleteCharAt(path.length() - 1);
        path = builder.toString();
        return String.format("%sVAT-%s-%d.%s", path, name, new Date().getTime(), extension);
    }

    void removeCreatedFiles() {
        createdFiles.forEach(fileLocation -> {
            File file = new File(fileLocation);

            if (!file.delete()) {
                System.out.printf("Failed to delete the file (%s)%n", fileLocation);
            }
        });
    }
}
