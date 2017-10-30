package com.hotelInterface;

import com.hotelInterface.controller.MenuController;
import com.hotelInterface.service.MainService;

public class Main {

    public static void main(String[] args) {

        MainService.getMainService().startHotel( "D:\\Rooms.txt");


        MenuController menuController=new MenuController();
        menuController.run();

    }

}
