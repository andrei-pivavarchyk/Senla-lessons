package com.configurator.entity;


public enum PropertyFilePath {

    CONFIG_HOTEL_PROPERTIES("../resources/config.properties");

    private String path;

    PropertyFilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}


