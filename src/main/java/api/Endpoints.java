package api;

public enum Endpoints {

    BASE_URI("https://goldapple.by"),
    HAIR_MASKS_URI(BASE_URI.getUri() + "/volosy/uhod-za-volosami/maski?format=json"),
    HAIR_MASKS_PAGE_OPTIONAL_URI(BASE_URI.getUri() + "/front/api/catalog/products?categoryId=2000000362&cityId=relation:59195&pageNumber=%s");

    Endpoints(final String uri) {
        this.uri = uri;
    }

    private final String uri;

    public String getUri() {
        return uri;
    }
}
