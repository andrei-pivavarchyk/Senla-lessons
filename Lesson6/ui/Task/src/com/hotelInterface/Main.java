package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import property.PropertyService;
import com.hotelInterface.service.MainService;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        MainService.getMainService().startHotel( "D:\\Rooms.txt");


        MenuController menuController=new MenuController();
        menuController.run();

    }

}
