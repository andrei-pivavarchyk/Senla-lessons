package com.configurator.entity;

public class Test1 {
    @ConfigProperty(configName = PropertyFilePath.CONFIG, propertyName = PropertyName.MAX_NUMBER_OF_LAST_ROOM_GUESTS, type = PropertyType.INTEGER)
    private int number;
    @Configurable()
    private Test2 test2;

    public int getNumber() {
        return number;
    }

    public Test2 getTest2() {
        return test2;
    }

    public void setTest2(Test2 test2) {
        this.test2 = test2;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
