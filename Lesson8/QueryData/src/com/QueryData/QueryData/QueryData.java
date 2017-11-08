package com.QueryData.QueryData;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class QueryData implements Serializable{
    public QueryData(){}

    private Class someClass;
    private String someMethod;
    private List<Class> parameterClassList=new ArrayList<Class>();
    private List<Object> allParamList=new ArrayList<Object>();

    public void setSomeClass(Class someClass) {
        this.someClass = someClass;
    }

    public void setSomeMethod(String someMethod) {
        this.someMethod = someMethod;
    }

    public Class getSomeClass() {
        return someClass;
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
