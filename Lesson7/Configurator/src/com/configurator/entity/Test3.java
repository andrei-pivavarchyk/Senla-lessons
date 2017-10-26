package com.configurator.entity;

public class Test3 {
    @ConfigProperty(configName = PropertyFileName.CONFIG, propertyName =PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS , type =PropertyType.INTEGER )
    public int number=777;

    public int getNumber() {
        return number;
    }
}
