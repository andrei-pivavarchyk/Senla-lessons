package com.serverQueryService.main;

import com.dependencyService.DependencyService;
import com.entity.Room;
import com.serverQueryService.ClientQueryService.ClientQueryService;
import com.serverQueryService.ClientQueryService.IClientQueryService;
import com.serverQueryService.ClientQueryService.ObjectToJsonConverter;
import com.serverQueryService.ClientQueryService.QueryData;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;

public class Main {
    public static void main(String[] args){

        ObjectToJsonConverter objectToJsonConverter=new ObjectToJsonConverter();

        IClientQueryService clientQueryService=(IClientQueryService)DependencyService.getDI().getInstance(IClientQueryService.class);
        QueryData queryData=new QueryData();
        queryData.setSomeMethod("addRoom");
        Room room=new Room(1,2,3,4,17);
        queryData.getAllParamList().add(room);
        String query=ObjectToJsonConverter.convertObject(queryData);
       // System.out.println(query);
        ClientQueryService.queryHandler(query);

    }
}
