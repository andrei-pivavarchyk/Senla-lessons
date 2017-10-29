package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import property.PropertyService;
import com.hotelInterface.service.MainService;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

       PropertyService propertyService=new PropertyService();
        Properties properties=propertyService.readProperties("../resources/config.properties");

        try {
            MainService.getMainService().startHotel( "D:\\Rooms.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }


        MenuController menuController=new MenuController();
        menuController.run();


    }

}
