package com.hotelInterface.action.roomMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.entity.Room;

import java.util.List;


public class ActionShowAllRoomsSortedByCapacity extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        List<Room> roomList = getClientService().getRoomCapacitySorting();
        getPrinter().printRooms(roomList);

        return ActionEnumResult.TRUE;
    }
}
