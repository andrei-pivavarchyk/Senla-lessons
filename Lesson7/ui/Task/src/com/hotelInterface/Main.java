package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import com.hotelInterface.service.StartHotelService;

public class Main {

    public static void main(String[] args) {

        try {
            StartHotelService.getStartHotelService().startHotel();
        } catch (Exception e) {
            e.printStackTrace();
        }


        MenuController menuController=new MenuController();
        menuController.run();


    }

}
