package com.queryService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryData implements Serializable {
    public QueryData(){}

    private String someClass;
    private String someMethod;
    private List<Class> parameterClassList=new ArrayList<Class>();
    private List<Object> allParamList=new ArrayList<Object>();

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

    public List<Class> getParameterClassList() {
        return parameterClassList;
    }

    public List<Object> getAllParamList() {
        return allParamList;
    }
}