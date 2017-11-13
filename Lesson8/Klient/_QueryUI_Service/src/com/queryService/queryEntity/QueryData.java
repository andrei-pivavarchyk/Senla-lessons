package com.queryService.queryEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryData implements Serializable {
    public QueryData(){}


    private String someMethod;
    private List<Object> allParamList=new ArrayList<Object>();

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