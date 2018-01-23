package com.servlet;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class GuestSortingServlet extends HttpServlet {

    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        List<Guest> guestList = new ArrayList<Guest>();

        if (request.getParameter("sorting") != null) {
            TypeSorting typeSorting = TypeSorting.getTypeSorting(request.getParameter("sorting"));
            if (typeSorting != null) {
                guestList = hotelController.getAllGuests(typeSorting);
            }
        } else {
            guestList = hotelController.getAllGuests(TypeSorting.NO_SORTING);
        }
        String guestListJson = ObjectConverterToJson.convertObject(guestList);
        PrintWriter pw = response.getWriter();
        pw.println(guestListJson);
    }

}
