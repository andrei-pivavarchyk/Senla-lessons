package com.servlet;


import com.dao.GuestDAO;

import com.dao.TypeSorting;

import com.testHotel.controller.HotelController;


public class Main {
    public static void main(String[] args) {
        HotelController hotelController=new HotelController();
        GuestDAO guestDAO=new GuestDAO();
        System.out.print(guestDAO.getAllEntities(TypeSorting.NO_SORTING));
    }
}
