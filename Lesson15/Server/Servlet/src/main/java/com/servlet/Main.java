package com.servlet;

import com.dao.TypeSorting;
import com.testHotel.controller.HotelController;

public class Main {
    public static void main(String[] args) {
        HotelController hotelController=new HotelController();
        System.out.print( hotelController.getAllGuests(TypeSorting.NO_SORTING));
    }
}
