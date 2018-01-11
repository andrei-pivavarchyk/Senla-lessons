package com.configurator;


public enum PropertyFilePath {

    CONFIG_HOTEL_PROPERTIES("config.properties"),
    CONFIG_DEPENDENCY("dependency.properties");

    private String path;

    PropertyFilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}


