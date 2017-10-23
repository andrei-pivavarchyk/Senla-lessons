package com.hotelInterface.action.roomMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.testHotel.entity.Room;

import java.util.List;

public class ActionShowAllRooms extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        List<Room> roomList = getHotelController().getRoomService().getAllRooms();
        getPrinter().printRooms(roomList);


        return ActionEnumResult.NEXT;
    }
}
