package enums;

import java.nio.file.Path;
import java.nio.file.Paths;

public enum ProjectPaths {
    ARTIFACTS_FOLDER(Paths.get("src", "main", "java", "api", "artifacts")),
    PRODUCT_IDS_CSV_FILE(ARTIFACTS_FOLDER.getPath().resolve("product_ids.csv")),
    PRODUCTS_JSON_FILE(ARTIFACTS_FOLDER.getPath().resolve("products.json")),
    FILTERED_PRODUCTS_JSON_FILE(ARTIFACTS_FOLDER.getPath().resolve("filtered_products.json")),


    ;

    private final Path path;

    ProjectPaths(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}
