package com.configurator.entity;

public class Test3 {
    @ConfigProperty(configName = PropertyFilePath.CONFIG, propertyName =PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS , type =PropertyType.INTEGER )
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}
