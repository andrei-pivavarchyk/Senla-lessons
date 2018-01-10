package com.servlet;


import com.dao.GuestDAO;
import com.dao.IRoomDAO;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.propertyService.PPropertyService;
import com.serverQueryService.ClientQueryService.ClientQueryService;
import com.serverQueryService.ClientQueryService.ObjectToJsonConverter;
import com.testHotel.controller.IHotelController;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        GuestDAO guestDAO = new GuestDAO();
        Integer id = 3;
        Guest guest = guestDAO.getEntityById(id);
        String str = ObjectConverterToJson.convertObject(guest);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Guest guest1 = (Guest)  objectMapper.readValue("{\"type\":\"Guest\",\"id\":3,\"name\":\"bob\",\"surname\":\"white\"}",
                    Guest.class);
            System.out.println(guest1.getSurname());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
