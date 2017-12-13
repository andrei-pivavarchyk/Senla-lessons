package com.testHotel.main;



import com.dependencyService.DependencyService;
import com.testHotel.controller.HotelController;
import com.dao.*;
import com.testHotel.entity.*;
import com.testHotel.service.GuestService;
import com.testHotel.service.IGuestService;
import com.testHotel.service.PrinterService;
import com.testHotel.service.RoomService;
import org.apache.log4j.Logger;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();

        // NetServerThread.start();
        Room room = new Room(44, 5550005, 3, 3);
        Guest guest=new Guest(1,"bob","jjj");



        GuestService guestService=new GuestService();
        RoomService roomService=new RoomService();
        PrinterService printerService=new PrinterService();

        System.out.println("departureGuest");
        roomService.departureGuest(guest);

/*




   Room room = new Room(44, 5550005, 3, 3);
        System.out.println("getCountOldRoomGuests");
        Integer count=roomService.getCountOldRoomGuests(room);
        System.out.println(count);
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








        GUESTSERVICE
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



ROOMSERVICE

        System.out.println("getAllRooms");
        printerService.printRooms(roomService.getAllRooms());

        System.out.println("getRoomCostSorting");
        printerService.printRooms(roomService.getRoomCostSorting());

        System.out.println("getRoomCapacitySorting");
        printerService.printRooms(roomService.getRoomCapacitySorting());

        System.out.println("getRoomStarsSorting");
        printerService.printRooms(roomService.getRoomStarsSorting());

         System.out.println("getRoomByNumber");
        Room room1=roomService.getRoomByNumber(1);
        List<Room> list=new ArrayList<Room>();
        list.add(room1);
        printerService.printRooms(list);

         System.out.println("addGuest");
        roomService.addGuest(1,guest,2018,2,2);

*/


    }
}




