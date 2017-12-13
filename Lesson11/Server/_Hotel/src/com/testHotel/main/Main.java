package com.testHotel.main;



import com.dependencyService.DependencyService;
import com.testHotel.controller.HotelController;
import com.dao.*;
import com.testHotel.entity.*;
import com.testHotel.service.GuestService;
import com.testHotel.service.IGuestService;
import com.testHotel.service.PrinterService;

import java.sql.Timestamp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();

        // NetServerThread.start();
        Guest guest=new Guest(1,"bob","jjj");

        GuestService guestService=new GuestService();

        PrinterService printerService=new PrinterService();




        /*





        System.out.println("getAllGuests");
        printerService.printGuests(guestService.getAllGuests());
        System.out.println("getAllGuestsSortedByDateDeparture");
        printerService.printGuests(guestService.getAllGuestsSortedByDateDeparture());
        System.out.println("getAllGuestsSortedByName");
        printerService.printGuests(guestService.getAllGuestsSortedByName());
  System.out.println("getAllGuestsCount");
        printerService.printString(guestService.getAllGuestsCount().toString());
        System.out.println("getPayAmount");
        printerService.printString(guestService.getPayAmount(guest).toString());
         System.out.println("getAllGuestsSortedByName");
        printerService.printGuests(guestService.getAllGuestsSortedByName());
*/


















/*
        Room room = new Room(44, 5550005, 3, 3);
        Guest guest=new Guest(1,"bob","jjj");
          Service service=new Service(8,ServiceType.EAT,"vodka",88);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(8,guest,service,new Date());
        GuestRoomInfo guestRoomInfo=new GuestRoomInfo(2,new Date(),guest,room,2018,2,6);

        hotelController.addService(service);
        hotelController.addRoom(room);
        hotelController.addGuest(44,guest,2018,4,3);
        hotelController.addGuestService(guest,service,2018,4,4);
*/

    }
}




