package com.servlet;

import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.Room;
import com.entity.RoomStatus;
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

public class RoomSortingServlet extends HttpServlet {

    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ObjectMapper objectMapper = new ObjectMapper();
    public static final Logger log = org.apache.log4j.Logger.getLogger(GuestServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Room> roomList = new ArrayList<Room>();
        TypeSorting typeSorting = this.getTypeSorting(request.getParameter("sorting"));
        RoomStatus roomStatus = this.getRoomStatus(request.getParameter("status"));
        if (typeSorting != null && roomStatus != null) {
            roomList = hotelController.getAllRooms(typeSorting, roomStatus);
        }
        String guestListJson = ObjectConverterToJson.convertObject(roomList);
        PrintWriter pw = response.getWriter();
        pw.println(guestListJson);
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

    public RoomStatus getRoomStatus(String status) {
        RoomStatus roomStatusQuery = null;
        for (RoomStatus roomStatus : RoomStatus.values()) {
            if (roomStatus.getStatus().equals(status)) {
                roomStatusQuery = roomStatus;
            }
        }
        return roomStatusQuery;
    }

}
