package com.servlet;

import com.dao.GuestDAO;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.Room;
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
import static java.lang.Integer.parseInt;

public class RoomServlet extends HttpServlet {
    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger log = org.apache.log4j.Logger.getLogger(GuestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            Room room=hotelController.getRoomById(id);
            String guestJson = ObjectConverterToJson.convertObject(room);
            PrintWriter pw = response.getWriter();
            pw.println(guestJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        String query=null;
        BufferedReader reader = request.getReader();
        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }
        try {
            Room room = this.objectMapper.readValue(sb.toString(),Room.class);
            this.hotelController.updateRoom(room);
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
        String query=null;
        BufferedReader reader = request.getReader();
        while ((query = reader.readLine()) != null) {
            sb.append(query);
        }

        try {
            Room room =this.objectMapper.readValue(sb.toString(), Room.class);
            this.hotelController.addRoom(room);
            PrintWriter pw = response.getWriter();
            pw.println(sb);
        } catch (IOException e) {
            log.error(e.toString());
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            hotelController.deleteRoom(id);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        }
    }
}
