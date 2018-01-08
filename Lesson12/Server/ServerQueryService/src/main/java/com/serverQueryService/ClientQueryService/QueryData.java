package com.serverQueryService.ClientQueryService;


import com.entity.HotelEntity;
import com.entity.Room;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class QueryData {

    private String someMethod;

    private List<HotelEntity> allParamList;

    @JsonCreator
    public QueryData(@JsonProperty("someMethod") String someMethod) {
    this.someMethod=someMethod;
allParamList=new ArrayList<HotelEntity>();
    }

    public void setSomeMethod(String someMethod) {
        this.someMethod = someMethod;
    }

    public String getSomeMethod() {
        return someMethod;
    }

    public List<HotelEntity> getAllParamList() {
        return allParamList;
    }

    public void setAllParamList(List<HotelEntity> allParamList) {
        this.allParamList = allParamList;
    }
}