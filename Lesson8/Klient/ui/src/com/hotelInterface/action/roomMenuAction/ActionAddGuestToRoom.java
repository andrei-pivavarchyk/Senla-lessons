package com.hotelInterface.action.roomMenuAction;


import com.QueryData.QueryData.QueryData;
import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;

import com.hotelInterface.entity.ActionEnumResult;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ActionAddGuestToRoom extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        ArrayList<Room> roomList=getHotelController().getRoomService().getFreeRooms();
        getPrinter().printRooms(roomList);

        getPrinter().printString("Enter room number");
        int freeRoomsCount = getHotelController().getRoomService().getFreeRooms().size();
        Room room;
        int roomNumber = 0;
        Boolean getRoom = false;
        while (getRoom.equals(false)) {
            roomNumber = getConsoleService().getNumber();
            if (roomNumber <= freeRoomsCount && roomNumber > 0) {
                room = getHotelController().getRoomService().getRoomByNumber(roomNumber);
                getRoom = true;
            } else {
                getPrinter().printString("Try again");
            }
        }


        getPrinter().printString("Enter guest name");
        String name = getConsoleService().getString();
        getPrinter().printString("Enter guest surname");
        String surname = getConsoleService().getString();
        getPrinter().printString("Enter guest id");
        int id = getConsoleService().getNumber();
        Guest guest = new Guest(id, name, surname);
        getPrinter().printString("Enter guest departure year");
        int year = getConsoleService().getNumber();
        getPrinter().printString("Enter guest departure month");
        int month = getConsoleService().getNumber();
        getPrinter().printString("Enter guest departure day");
        int day = getConsoleService().getNumber();


        QueryData queryData = new QueryData();
        queryData.setSomeClass(IHotelController.class);
        queryData.setSomeMethod("addGuest");
        queryData.getParameterClassList().add(Integer.class);
        queryData.getParameterClassList().add(Guest.class);
        queryData.getParameterClassList().add(Integer.class);
        queryData.getParameterClassList().add(Integer.class);
        queryData.getParameterClassList().add(Integer.class);

        queryData.getAllParamList().add(roomNumber);
        queryData.getAllParamList().add(guest);
        queryData.getAllParamList().add(year);
        queryData.getAllParamList().add(month);
        queryData.getAllParamList().add(day);

        getClientSocket().start(queryData);


        return ActionEnumResult.TRUE;

    }
}
