import api.Endpoints;
import api.ProductIdsAggregator;
import api.ProductParser;
import api.models.Product;
import api.serialization.Deserializer;
import api.serialization.Serializer;
import enums.ProjectPaths;
import filtering.Filter;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.CsvFileUtility;

import java.util.List;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    @Test
    @Order(1)
    public void gatherAllIdsIntoCsv() {
        List<String> allProductIds = ProductIdsAggregator.getProductIdsFromAllPages(Endpoints.HYGIENE_PAGE_NUMBER_URI);
        CsvFileUtility.createNewCsvAndWriteListOfLines(allProductIds);
    }

    @Test
    @Order(2)
    public void getProductsListFromCsvAndSerialize() {
        List<Product> products = ProductParser.createProductsUsingCsvIds();
        Serializer.serializeListOfProducts(products, ProjectPaths.ARTIFACTS_FOLDER, ProjectPaths.PRODUCTS_JSON_FILE);
    }


//    @ParameterizedTest
//    @MethodSource("hygieneFoamFilters")
    @Test
    @Order(3)
    public void deserializeProductsFromJsonAndFilterIntoJson() {
        List<String> filters = List.of("acid");
        List<Product> products = Deserializer.deserializeProductsFronJson(ProjectPaths.PRODUCTS_JSON_FILE);
        List<Product> filteredProducts = Filter.excludeIngredients(products, filters);
        filteredProducts.forEach(product -> {
            System.out.println("_____________________");
            System.out.println(product.id);
            System.out.println(product.name);
            System.out.println(product.url);
            System.out.println(product.price);
            System.out.println(product.ingredients);
            System.out.println("_____________________");
        });
        Serializer.serializeListOfProducts(filteredProducts, ProjectPaths.ARTIFACTS_FOLDER, ProjectPaths.FILTERED_PRODUCTS_JSON_FILE);
    }

//    static List<String> hygieneFoamFilters() {
//        return List.of("acid");
//    }
}
