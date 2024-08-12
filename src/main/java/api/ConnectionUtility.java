package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConnectionUtility {

    public static Response makeGetRequestToUriAndReturnResponse(Endpoints endpoint) {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .when()
                .get("https://goldapple.by/front/api/catalog/products?categoryId=2000000362&cityId=relation:59195&pageNumber=2&customerGroupId=6")
//                .get(endpoint.getUri())
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.getBody().asString());
        return response;
    }

}
