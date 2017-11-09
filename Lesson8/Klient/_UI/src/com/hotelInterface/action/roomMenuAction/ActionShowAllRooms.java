package com.hotelInterface.action.roomMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.queryService.hotelEntity.Room;

import java.util.List;

public class ActionShowAllRooms extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {


            List<Room> allRooms =getClientService().getAllRooms();

            getPrinter().printRooms(allRooms);

        return ActionEnumResult.NEXT;
    }
}
