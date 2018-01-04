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
    public QueryData(@JsonProperty("someMethod") String someMethod,@JsonProperty("allParamList") List<HotelEntity> allParamList) {
    this.someMethod=someMethod;
    this.allParamList=allParamList;
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
}