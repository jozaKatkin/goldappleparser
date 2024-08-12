package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConnectionUtility {

    public static Response makeGetRequestToUriAndReturnResponse(Endpoints endpoint) {
        Response response = RestAssured.given()
//                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint.getUri())
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.getBody().asString());
        return response;
    }

}
