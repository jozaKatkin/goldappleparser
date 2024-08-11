package api;

import io.restassured.response.Response;

import java.util.List;

public class ProductParser {

    private static final String productPath = "data.products.itemId";

    public static List<String> getProducts() {
        Response response = ConnectionUtility.makeGetRequestToUriAndReturnResponse(Endpoints.HAIR_MASKS_URI);
        return JsonParser.getStringListFromResponseByItemPath(response, productPath);
    }
}
