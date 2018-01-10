package com.servlet;


import com.dao.GuestDAO;
import com.dao.IRoomDAO;
import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.propertyService.PPropertyService;
import com.serverQueryService.ClientQueryService.ClientQueryService;
import com.serverQueryService.ClientQueryService.ObjectToJsonConverter;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        HotelController hotelController=new HotelController();
        GuestDAO guestDAO=new GuestDAO();
        System.out.print(guestDAO.getAllEntities(TypeSorting.NO_SORTING));
    }
}
