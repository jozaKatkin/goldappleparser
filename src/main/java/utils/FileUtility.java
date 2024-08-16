package utils;

import enums.ProjectPaths;

import java.io.IOException;
import java.nio.file.Files;

public class FileUtility {

    public static void createDirIfNotExists(ProjectPaths path) {
        try {
            Files.createDirectories(path.getPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}