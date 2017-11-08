package com.hotelInterface.action.roomMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.queryService.hotelEntity.Room;

import java.util.List;

public class ActionShowFreeRoomsSortedByCapacity extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        List<Room> roomList = getClientService().getFreeRooms();
        roomList = getClientService().getArrayRoomCapacitySorting(roomList);
        getPrinter().printRooms(roomList);

        return ActionEnumResult.TRUE;

    }
}
