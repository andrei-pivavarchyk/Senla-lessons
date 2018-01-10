package com.serverQueryService.main;

import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.HotelEntity;
import com.entity.Room;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverQueryService.ClientQueryService.*;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        List<HotelEntity> list=new ArrayList<>();
        Room room=new Room(1,2,3,4,5);
        list.add(room);
QueryData queryData=new QueryData("getAllRooms");
//queryData.setAllParamList(list);
Guest guest=new Guest(1,"fdsfs","dsf");
System.out.println(ObjectToJsonConverter.convertObject(guest));
String str="{\"someMethod\":\"addRoom\",\"allParamList\":[{\"type\":\"room\",\"id\":1,\"number\":2,\"cost\":3,\"capacity\":4,\"stars\":5,\"status\":\"FREE\"}]}";

   // ClientQueryService.queryHandler(ObjectToJsonConverter.convertObject(queryData));

    }
}
