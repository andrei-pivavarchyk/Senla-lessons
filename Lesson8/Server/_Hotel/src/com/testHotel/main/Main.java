package com.testHotel.main;


import com.dependencyService.DependencyService;
import com.serverQueryService.ClientQueryService.NetServerThread;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.HotelService;

public class Main {
    public static void main(String[] args) {

        HotelService hotelService=new HotelService();
        hotelService.startHotel();

        NetServerThread.start();

    }
}




