package com.testHotel.main;



import com.dependencyService.DependencyService;
import com.testHotel.controller.HotelController;
import com.testHotel.dao.GuestRoomInfoDAO;
import com.testHotel.dao.GuestServiceDAO;
import com.testHotel.dao.IGuestRoomInfoDAO;
import com.testHotel.dao.ServiceDAO;
import com.testHotel.entity.*;
import java.sql.Timestamp;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();

        // NetServerThread.start();

       IGuestRoomInfoDAO guestRoomInfoDAO = (IGuestRoomInfoDAO) DependencyService.getDI().getInstance(IGuestRoomInfoDAO.class);
        System.out.println(guestRoomInfoDAO);
/*
        Room room = new Room(44, 5550005, 3, 3);
        Guest guest=new Guest(1,"bob","jjj");
          Service service=new Service(8,ServiceType.EAT,"vodka",88);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(8,guest,service,new Date());
        GuestRoomInfo guestRoomInfo=new GuestRoomInfo(2,new Date(),guest,room,2018,2,6);
       System.out.println(IGuestRoomInfoDAO.class.getName());

        hotelController.addService(service);
        hotelController.addRoom(room);
        hotelController.addGuest(44,guest,2018,4,3);
        hotelController.addGuestService(guest,service,2018,4,4);
*/
    }
}




