package api;

public enum Endpoints {

    BASE_URI("https://goldapple.by"),
    HAIR_MASKS_URI(BASE_URI.getUri() + "/volosy/uhod-za-volosami/maski");

    Endpoints(final String uri) {
        this.uri = uri;
    }

    private final String uri;

    public String getUri() {
        return uri;
    }
}
