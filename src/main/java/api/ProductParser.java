package api;

import api.models.Product;
import io.restassured.response.Response;
import utils.CsvFileUtility;

import java.util.ArrayList;
import java.util.List;

public class ProductParser {

    private static final String productContentsPath = "data.productDescription.content";
    private static final String productNamePath = "data.name";
    private static final String productPricePath = "data.variants.price.actual.amount[0]";
    private static final String productUrlPath = "data.variants.url";

    public static Response getProductResponse(String productId) {
        return ConnectionUtility.makeGetRequestToUriAndReturnResponse(Endpoints.PRODUCT_ID_URI, productId);
    }

    public static Product createProductFromResponse(String productId) {
        Response response = getProductResponse(productId);

        String name = response.jsonPath().getString(productNamePath);
        int price = response.jsonPath().getInt(productPricePath);
        String url = response.jsonPath().getString(productUrlPath);

        List<String> description = response.jsonPath().getList(productContentsPath);

        String ingredients = "No ingredients where found";
        if (description.size() >= 4) {
            ingredients = description.reversed().get(2);
        }

        return new Product(productId, name, price, ingredients, url);
    }

    public static List<Product> createProductsUsingCsvIds() {
        List<String> ids = CsvFileUtility.readLinesFromCsv();
        List<Product> products = new ArrayList<>();
        ids.forEach(id -> products.add(createProductFromResponse(id)));
        return products;
    }
}
