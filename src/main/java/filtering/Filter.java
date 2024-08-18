package filtering;

import api.models.Product;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<Product> excludeIngredients(List<Product> allProducts, List<String> ingredientsToExclude) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : allProducts) {
            boolean isExcluded = false;
            for (String ingredient : ingredientsToExclude) {
                if (product.ingredients.toLowerCase().contains(ingredient)) {
                    isExcluded = true;
                    break;
                }
            }
            if (!isExcluded) {
                filteredProducts.add(product);
            }
        }

        return filteredProducts;
    }
}
