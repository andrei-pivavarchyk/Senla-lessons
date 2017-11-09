package com.testHotel.main;


import com.serverQueryService.ClientQueryService.NetServerThread;
import com.testHotel.service.StartHotelService;

public class Main {
    public static void main(String[] args) {
       StartHotelService startHotelService=new StartHotelService();
       startHotelService.startHotel();

       NetServerThread.start();
    }
}




