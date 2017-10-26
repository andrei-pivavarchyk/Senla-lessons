package com.configurator.entity;

public class Test2 {
    @ConfigProperty(configName = PropertyFileName.CONFIG, propertyName =PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS , type =PropertyType.INTEGER )
    public int number=666;
    @Configurable()
    public Test3 test3=new Test3();

    public int getNumber() {
        return number;
    }

    public Test3 getTest3() {
        return test3;
    }
}
