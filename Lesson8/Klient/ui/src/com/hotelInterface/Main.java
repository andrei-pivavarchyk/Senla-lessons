package com.hotelInterface;

import com.QueryData.QueryData.QueryData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.controller.MenuController;
import com.hotelInterface.querySenderService.ClientSocket;
import com.hotelInterface.service.StartHotelService;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;

import java.io.IOException;
import java.util.List;

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
