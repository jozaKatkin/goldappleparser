import api.models.Product;
import api.serialization.Deserializer;
import enums.ProjectPaths;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BaseTest {

    @Test
    public void test() {
//        List<String> allProductIds = ProductParser.getProductIdsFromAllPages();

//        Product product = ProductParser.createProductFromResponse("19000041719");
//        System.out.println(product.id);
//        System.out.println(product.name);
//        System.out.println(product.url);
//        System.out.println(product.price);
//


//        List<String> ids = ProductIdsAggregator.getProductIdsListFromPageNumber(19);
//
//        CsvFileUtility.createNewCsvAndWriteListOfLines(ids);
//        List<Product> products = ProductParser.createProductsUsingCsvIds();



//        Serializer.serializeListOfProducts(products, ProjectPaths.ARTIFACTS_FOLDER, ProjectPaths.PRODUCTS_JSON_FILE);

        List<Product> products = Deserializer.deserializeProductsFronJson(ProjectPaths.PRODUCTS_JSON_FILE);
        products.forEach(product -> {
            System.out.println("_____________________");
            System.out.println(product.id);
            System.out.println(product.name);
            System.out.println(product.url);
            System.out.println(product.price);
            System.out.println(product.ingredients);
            System.out.println("_____________________");
        });
    }


}
