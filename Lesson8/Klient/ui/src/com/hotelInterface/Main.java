package com.hotelInterface;

import com.QueryData.QueryData.QueryData;
import com.hotelInterface.controller.MenuController;
import com.hotelInterface.querySenderService.ClientSocket;
import com.hotelInterface.service.StartHotelService;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;

import java.util.List;

public class Main {

    public static void main(String[] args) {

       StartHotelService startHotelService = new StartHotelService();
      startHotelService.startHotel();
       MenuController menuController = new MenuController();
        menuController.run();



    }
}
