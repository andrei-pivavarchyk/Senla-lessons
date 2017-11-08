package com.testHotel.main;


import com.QueryData.QueryData.QueryData;
import com.dependencyService.DependencyService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.clientQuery.NetServerThread;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Room;
import com.testHotel.service.IPrinterService;
import com.testHotel.service.IRoomService;
import com.testHotel.service.PrinterService;
import com.testHotel.service.StartHotelService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
       StartHotelService startHotelService=new StartHotelService();
       startHotelService.startHotel();
      //  NetServerThread.start();

IHotelController hotelController=(IHotelController)DependencyService.getDI().getInstance(IHotelController.class);
        List<Room> rooms=hotelController.getAllRooms();

        ObjectMapper mapper = new ObjectMapper();
        try {
            String serialized = mapper.writeValueAsString(rooms);

           List<Room> allRooms= mapper.readValue(serialized,new TypeReference<List<Room>>(){});

            System.out.print(allRooms.get(0).getStatus());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}




