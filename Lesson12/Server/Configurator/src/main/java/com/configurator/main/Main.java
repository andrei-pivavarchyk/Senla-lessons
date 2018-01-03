package com.configurator.main;

import com.configurator.Configurator;
import com.testHotel.controller.HotelController;
import com.testHotel.service.RoomService;

public class Main {
    public static void main(String[] args) {
        RoomService roomService= new RoomService();
        Configurator configurator=new Configurator();
        System.out.println(roomService);
        configurator.configure(roomService);

    }
}
