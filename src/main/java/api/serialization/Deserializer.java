package api.serialization;

import api.models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.ProjectPaths;
import utils.FileUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Deserializer {

    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static List<Product> deserializeProductsFronJson(ProjectPaths filePath) {
        FileUtility.checkIfPathExists(filePath);
        List<Product> products;
        try {
            products = objectMapper.readValue(new File(filePath.getPath().toString()), new TypeReference<List<Product>>() {});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
