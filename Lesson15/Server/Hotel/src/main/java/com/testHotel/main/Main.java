package com.testHotel.main;


import com.dao.GuestDAO;
import com.testHotel.controller.HotelController;
import com.testHotel.service.GuestService;

public class Main {
    public static void main(String[] args) {
        HotelController hotelController=new HotelController();
        GuestService guestService=new GuestService();
        GuestDAO guestDAO=new GuestDAO();
        System.out.print( hotelController.getGuestById(2));
    }
}




