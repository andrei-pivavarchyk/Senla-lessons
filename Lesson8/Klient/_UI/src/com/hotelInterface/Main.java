package com.hotelInterface;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.controller.MenuController;
import com.hotelInterface.service.StartHotelService;
import com.queryService.ClientSocket;
import com.queryService.QueryData;
import com.queryService.hotelEntity.Room;

import java.io.IOException;


public class Main {

    public static void main(String[] args) {



          StartHotelService startHotelService = new StartHotelService();
         startHotelService.startHotel();
          MenuController menuController = new MenuController();
          menuController.run();

/*
        QueryData queryData = new QueryData();
        queryData.setSomeClass(IHotelController.class);
        queryData.setSomeMethod("getAllRooms");

        String someObject =  ClientSocket.start(queryData);
        System.out.print(someObject);
        ObjectMapper mapper = new ObjectMapper();
        try {

            List<Room> allRooms= mapper.readValue(someObject,new TypeReference<List<Room>>(){});

            System.out.println(allRooms.get(0).getStatus().getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
