package com.servlet;

import com.dao.TypeSorting;
import com.entity.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.HotelController;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        String str="{\"type\":\"Guest\",\"id\":8,\"name\":\"Mar\",\"surname\":\"Mar\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Guest guest = new Guest(1,"fds","fds");
        try {
            guest = objectMapper.readValue(str, Guest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(ObjectConverterToJson.convertObject(guest));
        HotelController hotelController=new HotelController();
        hotelController.addGuest(guest);
        
    }
}
