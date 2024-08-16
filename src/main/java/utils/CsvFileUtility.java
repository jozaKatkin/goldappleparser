package utils;

import enums.ProjectPaths;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;


/**
 * I know it's better to abstract CsvFileUtility to read\write any file,
 * but for the current project there's no need to waste time for this,
 * because I will use CsvFileUtility ONLY for 1 single action
 */
public class CsvFileUtility {

//    private static final Path dirPath = Paths.get("src", "main", "java", "api", "artifacts");
//    private static final Path filePath = dirPath.resolve("product_ids.csv");

//    public static void createDirIfNotExists(Path path) {
//        try {
//            Files.createDirectories(path);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void createNewCsvAndWriteSingleLine(String line) {
        FileUtility.createDirIfNotExists(ProjectPaths.ARTIFACTS_FOLDER);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProjectPaths.PRODUCT_IDS_CSV_FILE.getPath().toString()))) {
            writer.write(line);
            writer.newLine();
            System.out.println(format("Product ID %s was written to %s", line, ProjectPaths.PRODUCT_IDS_CSV_FILE.getPath()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createNewCsvAndWriteListOfLines(List<String> lines) {
        FileUtility.createDirIfNotExists(ProjectPaths.ARTIFACTS_FOLDER);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ProjectPaths.PRODUCT_IDS_CSV_FILE.getPath().toString()))) {
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                if (i < lines.size() - 1) {
                    writer.newLine();
                }
            }
            System.out.println(format("Product IDs were written to %s", ProjectPaths.PRODUCT_IDS_CSV_FILE.getPath()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> readLinesFromCsv() {
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(ProjectPaths.PRODUCT_IDS_CSV_FILE.getPath())) {
            stream.forEach(lines::add);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
