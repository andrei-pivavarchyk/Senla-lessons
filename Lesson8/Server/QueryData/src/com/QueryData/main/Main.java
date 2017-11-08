package com.QueryData.main;

import com.QueryData.QueryData.QueryData;

public class Main {
    public static void main(String[] args){

        QueryData queryData=new QueryData();
        System.out.print(queryData.getAllParamList().isEmpty());
    }
}
