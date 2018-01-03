package com.serverQueryService.ClientQueryService;


import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.ArrayList;
import java.util.List;

public class QueryData {
    @JsonCreator
    public QueryData() {
    }

    private String someClass;
    private String someMethod;
    private List<Object> allParamList = new ArrayList<Object>();


    public void setSomeMethod(String someMethod) {
        this.someMethod = someMethod;
    }

    public String getSomeMethod() {
        return someMethod;
    }

    public List<Object> getAllParamList() {
        return allParamList;
    }
}