package com.servlet;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Room;
import com.entity.RoomStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.GuestService;
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

public class GuestServiceServlet extends HttpServlet {
    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger log = org.apache.log4j.Logger.getLogger(GuestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<GuestServiceInfo> roomList = new ArrayList<GuestServiceInfo>();
        TypeSorting typeSorting = this.getTypeSorting(request.getParameter("sorting"));
        Integer id = Integer.parseInt(request.getParameter("id"));
        if (typeSorting != null && id != null) {
            roomList = hotelController.getGuestServiceByGuest(id, typeSorting);
        }
        String guestServiceListJson = ObjectConverterToJson.convertObject(roomList);
        PrintWriter pw = response.getWriter();
        pw.println(guestServiceListJson);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        String query = null;
        BufferedReader reader = request.getReader();
        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }
        try {
            GuestServiceInfo guestServiceInfo = this.objectMapper.readValue(sb.toString(), GuestServiceInfo.class);
            this.hotelController.updateGuestServiceInfo(guestServiceInfo);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        String query = null;
        BufferedReader reader = request.getReader();
        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }
        try {
            GuestServiceInfo guestServiceInfo = this.objectMapper.readValue(sb.toString(), GuestServiceInfo.class);
            this.hotelController.addGuestServiceInfo(guestServiceInfo);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            hotelController.removeGuestServiceInfoByGuest(id);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        }

    }

    public TypeSorting getTypeSorting(String queryType) {
        TypeSorting typeSorting = null;
        for (TypeSorting type : TypeSorting.values()) {
            if (type.getType().equals(queryType)) {
                typeSorting = type;
            }
        }
        return typeSorting;
    }
}