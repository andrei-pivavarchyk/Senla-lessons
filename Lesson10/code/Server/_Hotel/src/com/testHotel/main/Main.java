package com.testHotel.main;


import com.serverQueryService.ClientQueryService.NetServerThread;
import com.testHotel.conection.ConnectionToMysql;
import com.testHotel.controller.HotelController;

public class Main {
    public static void main(String[] args) {

       HotelController hotelController=new HotelController();
        hotelController.startHotel();

       // NetServerThread.start();

        ConnectionToMysql.connectToBase();
    }
}




