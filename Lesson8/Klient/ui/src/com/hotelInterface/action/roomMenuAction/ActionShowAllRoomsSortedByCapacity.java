package com.hotelInterface.action.roomMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.testHotel.entity.Room;

import java.util.ArrayList;


public class ActionShowAllRoomsSortedByCapacity extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        ArrayList<Room> roomList = getHotelController().getRoomService().getRoomCapacitySorting();
        getPrinter().printRooms(roomList);
        return ActionEnumResult.TRUE;
    }
}
