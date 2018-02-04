package com.dao;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class TestClass {

    private String name="succes";
    public TestClass(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
