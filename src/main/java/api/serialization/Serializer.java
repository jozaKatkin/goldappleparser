package api.serialization;

import api.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.ProjectPaths;
import utils.FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Serializer {

    private static final ObjectMapper mapper = new ObjectMapper();


    public static void serializeListOfProducts(List<Product> products, ProjectPaths directory, ProjectPaths filePath) {
        FileUtility.createDirIfNotExists(directory);

        File file = new File(directory.getPath().toString(), filePath.getPath().getFileName().toString());
        try {
            mapper.writeValue(file, products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
