package com.serverQueryService.ClientQueryService;


import java.util.ArrayList;
import java.util.List;

public class QueryData {
    public QueryData() {
    }

    private String someClass;
    private String someMethod;
    private List<Object> allParamList = new ArrayList<Object>();

    public void setSomeClass(String someClass) {
        this.someClass = someClass;
    }

    public String getSomeClass() {
        return someClass;
    }

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