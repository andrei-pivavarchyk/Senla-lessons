
public enum PropertyFilePath {

    CONFIG_HOTEL_PROPERTIES("../resources/config.properties"),
    CONFIG_DEPENDENCY("../resources/dependency.properties");

    private String path;

    PropertyFilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}


