package com.hotelInterface.action.roomMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import java.util.List;

public class ActionShowFreeRooms extends AAction implements IAction {
    @Override
    public ActionEnumResult execute() {

        List< com.entity.Room> roomList = getClientService().getFreeRooms();
        getPrinter().printRooms(roomList);

        return ActionEnumResult.NEXT;

    }
}
