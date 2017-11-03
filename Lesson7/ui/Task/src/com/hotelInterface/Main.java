package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import com.hotelInterface.service.StartHotelService;
import com.propertyService.PropertyService;

public class Main {

    public static void main(String[] args) {
        StartHotelService startHotelService=new StartHotelService();
        MenuController menuController = new MenuController();
        menuController.run();
    }
}
