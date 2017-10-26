package com.configurator.entity;

public class Test1 {
    @ConfigProperty(configName = PropertyFileName.CONFIG, propertyName = PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS, type = PropertyType.INTEGER)
    public int number;
    @Configurable()
    public Test2 test2=new Test2();

    public int getNumber() {
        return number;
    }

    public Test2 getTest2() {
        return test2;
    }
}
