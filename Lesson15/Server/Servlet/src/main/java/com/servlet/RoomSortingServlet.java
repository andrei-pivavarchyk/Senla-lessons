package com.servlet;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Room;
import com.entity.RoomStatus;
import com.testHotel.controller.IHotelController;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class RoomSortingServlet extends HttpServlet {

    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        List<Room> roomList = new ArrayList<Room>();
        TypeSorting typeSorting = TypeSorting.getTypeSorting(request.getParameter("sorting"));
        RoomStatus roomStatus = RoomStatus.getRoomStatus(request.getParameter("status"));
        if (typeSorting != null && roomStatus != null) {
            roomList = hotelController.getAllRooms(typeSorting, roomStatus);
        }
        String guestListJson = ObjectConverterToJson.convertObject(roomList);
        PrintWriter pw = response.getWriter();
        pw.println(guestListJson);
    }
}
