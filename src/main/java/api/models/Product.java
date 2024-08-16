package api.models;

public class Product {

    public String id;
    public String name;
    public int price;
    public String ingredients;
    public String url;

    public Product(String id, String name, int price, String ingredients, String url) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.url = url;
    }

    public Product() {
    }
}
