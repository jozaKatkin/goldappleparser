package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConnectionUtility {

    public static Response makeGetRequestToUriAndReturnResponse(Endpoints endpoint) {
        return RestAssured.given()
                .header("Accept", "application/json")
                .when()
                .get(endpoint.getUri())
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
