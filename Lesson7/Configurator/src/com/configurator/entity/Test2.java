package com.configurator.entity;

public class Test2 {
    @ConfigProperty(configName = PropertyFilePath.CONFIG, propertyName =PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS , type =PropertyType.INTEGER )
    private int number=666;
    @Configurable()
    private Test3 test3;

    public int getNumber() {
        return number;
    }

    public Test3 getTest3() {
        return test3;
    }

    public void setTest3(Test3 test3) {
        this.test3 = test3;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
