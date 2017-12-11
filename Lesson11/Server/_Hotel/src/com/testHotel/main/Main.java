package com.testHotel.main;



import com.dependencyService.DependencyService;
import com.testHotel.controller.HotelController;
import com.dao.*;
import com.testHotel.entity.*;
import com.testHotel.service.IGuestService;

import java.sql.Timestamp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();

        // NetServerThread.start();

System.out.println(  (IGuestServiceDAO) DependencyService.getDI().getInstance(IGuestServiceDAO.class));

        Room room = new Room(44, 5550005, 3, 3);
        Guest guest=new Guest(1,"bob","jjj");
          Service service=new Service(8,ServiceType.EAT,"vodka",88);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(8,guest,service,new Date());
        GuestRoomInfo guestRoomInfo=new GuestRoomInfo(2,new Date(),guest,room,2018,2,6);

        hotelController.addService(service);
        hotelController.addRoom(room);
        hotelController.addGuest(44,guest,2018,4,3);
        hotelController.addGuestService(guest,service,2018,4,4);


    }
}




