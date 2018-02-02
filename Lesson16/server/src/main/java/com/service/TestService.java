package com.service;

import com.dao.TestClass;
import org.springframework.beans.factory.annotation.Autowired;

public class TestService {


    @Autowired
    private TestClass test;

public TestService(){}

    public void setTest(TestClass test) {
        this.test = test;
    }

    public TestClass getTest() {
        return test;
    }
}
