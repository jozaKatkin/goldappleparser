package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ConnectionUtility {

    public static Response makeGetRequestToUriAndReturnResponse(Endpoints endpoint) {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .when()
                .get(endpoint.getUri())
                .then()
                .statusCode(200)
                .extract()
                .response();
//        System.out.println(response.getBody().asString());
        return response;
    }

    public static Response makeGetRequestToUriAndReturnResponse(Endpoints endpoint, int option) {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .when()
                .get(String.format(endpoint.getUri(), option))
                .then()
                .statusCode(200)
                .extract()
                .response();
//        System.out.println(response.getBody().asString());
        return response;
    }

    public static Response makeGetRequestToUriAndReturnResponse(Endpoints endpoint, String option) {
        Response response = RestAssured.given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json; charset=UTF-8")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36")
                .when()
                .get(String.format(endpoint.getUri(), option))
                .then()
                .statusCode(200)
                .extract()
                .response();
//        System.out.println(response.getBody().asString());
        return response;
    }
}
