package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import property.PropertyService;
import com.hotelInterface.service.MainService;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        try {
            MainService.getMainService().startHotel();
        } catch (Exception e) {
            e.printStackTrace();
        }


        MenuController menuController=new MenuController();
        menuController.run();


    }

}
