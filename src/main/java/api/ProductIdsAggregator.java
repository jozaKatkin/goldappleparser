package api;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

public class ProductIdsAggregator {

    private static final String productIdPath = "data.products.itemId";
    private static final String totalNumberOfProductsPath = "data.count";
    private static final double numberOfProductsPerPage = 24;
    private static final int pageNumberToGetTotalProducts = 1;

    public static List<String> getProductIdsListFromPageNumber(int pageNumber, Endpoints endpoint) {
        Response response = ConnectionUtility.makeGetRequestToUriAndReturnResponse(endpoint, pageNumber);
        return response.jsonPath().getList(productIdPath);
    }

    public static List<String> getProductIdsFromAllPages(Endpoints endpoint) {
        List<String> allProductIds = new ArrayList<>();
        int totalNumberOfPages = getTotalNumberOfPages(endpoint);
        System.out.println("Total number of pages: " + totalNumberOfPages);

        for (int page = 1; page <= totalNumberOfPages; page++) {
            System.out.println("Current page: " + page);
            List<String> currentPageIds = getProductIdsListFromPageNumber(page, endpoint);
            currentPageIds.forEach(System.out::println);
            allProductIds.addAll(currentPageIds);
        }
        System.out.println("All products size: " + allProductIds.size());
//        allProductIds.forEach(System.out::println);
        return allProductIds;
    }

    private static int getTotalNumberOfPages(Endpoints endpoint) {
        double totalNumberOfProducts = getTotalNumberOfProducts(endpoint);
        return (int) Math.ceil(totalNumberOfProducts / numberOfProductsPerPage);
    }

    private static int getTotalNumberOfProducts(Endpoints endpoint) {
        Response response = ConnectionUtility.makeGetRequestToUriAndReturnResponse(endpoint, pageNumberToGetTotalProducts);
        return response.jsonPath().getInt(totalNumberOfProductsPath);
    }
}
