package com.servlet;

import com.dao.IRoomDAO;
import com.dao.RoomDAO;
import com.dependencyService.DependencyService;
import com.entity.Room;
import com.testHotel.controller.IHotelController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet  extends HttpServlet{
    private String responseTemplate =
            "<html>\n" +
                    "<body>\n" +
                    "<h2>Hello from Simple Servlet</h2>\n" +
                    "</body>\n" +
                    "</html>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        response.setContentType("application/json;charset=UTF-8");


    /*
        PrintWriter pw = response.getWriter();
        Room room=new Room(2,2,2,2,666);
       RoomDAO roomDAO=new RoomDAO();
       roomDAO.addEntity(room);
        response.getWriter().print(room.getNumber());*/
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(200);
        response.getWriter().write(responseTemplate);
    }

    protected void get(){}
}