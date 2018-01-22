package com.servlet;

import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.Service;
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

public class HotelServiceServlet extends HttpServlet {
    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger log = org.apache.log4j.Logger.getLogger(GuestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            Service service = hotelController.getServiceById(id);
            String guestJson = ObjectConverterToJson.convertObject(service);
            PrintWriter pw = response.getWriter();
            pw.println(guestJson);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getReader().readLine();

        try {
            Service service = this.objectMapper.readValue(query, Service.class);
            this.hotelController.updateService(service);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query = request.getReader().readLine();
        try {
            Service service = this.objectMapper.readValue(query, Service.class);
            this.hotelController.addHotelService(service);
            PrintWriter pw = response.getWriter();
            pw.println(query);
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("id") != null) {
            Integer id = parseInt(request.getParameter("id"));
            hotelController.deleteService(id);
            PrintWriter pw = response.getWriter();
            pw.println("succes");
        }
    }
}