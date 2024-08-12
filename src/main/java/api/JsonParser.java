package api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class JsonParser {

    private static JsonPath getJsonPathFromResponse(Response response) {
        return new JsonPath(response.asString());
    }

    public static List<String> getStringListFromResponseByItemPath(Response response, String itemPathInResponse) {
        return getJsonPathFromResponse(response).getList(itemPathInResponse);
    }

    public static int getIntFromResponseByPath(Response response, String pathInResponse) {
         return getJsonPathFromResponse(response).getInt(pathInResponse);
    }
}
