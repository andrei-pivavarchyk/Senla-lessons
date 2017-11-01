package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import com.hotelInterface.service.StartHotelService;

public class Main {

    public static void main(String[] args) {

        try {
            StartHotelService startHotelService=new StartHotelService();
            startHotelService.startHotel();
        } catch (Exception e) {
            e.printStackTrace();
        }


        MenuController menuController=new MenuController();
        menuController.run();


    }

}
