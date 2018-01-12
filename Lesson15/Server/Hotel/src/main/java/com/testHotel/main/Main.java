package com.testHotel.main;


import com.dao.ServiceDAO;
import com.entity.Guest;

import com.testHotel.controller.HotelController;
import com.testHotel.service.GuestService;

public class Main {
    public static void main(String[] args) {
        Guest guest=new Guest(3,"bob","white");
        HotelController hotelController=new HotelController();

    }
}




