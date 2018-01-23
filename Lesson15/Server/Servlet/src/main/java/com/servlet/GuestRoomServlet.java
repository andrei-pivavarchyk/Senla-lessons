package com.servlet;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestRoomInfo;
import com.entity.GuestServiceInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class GuestRoomServlet extends HttpServlet {

    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger log = org.apache.log4j.Logger.getLogger(GuestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        List<GuestRoomInfo> guestRoomInfoList = new ArrayList<GuestRoomInfo>();
        if (request.getParameter("sorting") != null) {
            TypeSorting typeSorting = TypeSorting.getTypeSorting(request.getParameter("sorting"));
            if (typeSorting != null) {
                guestRoomInfoList = hotelController.getAllGuestRoomInfo(typeSorting);
            }
        } else {
            guestRoomInfoList = hotelController.getAllGuestRoomInfo(TypeSorting.NO_SORTING);
        }
        String guestListJson = ObjectConverterToJson.convertObject(guestRoomInfoList);
        PrintWriter pw = response.getWriter();
        pw.println(guestListJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getReader().readLine();
        try {
            GuestRoomInfo guestRoomInfo = this.objectMapper.readValue(query, GuestRoomInfo.class);
            this.hotelController.addGuestRoomInfo(guestRoomInfo);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            hotelController.departureGuest(id);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        }
    }

}
