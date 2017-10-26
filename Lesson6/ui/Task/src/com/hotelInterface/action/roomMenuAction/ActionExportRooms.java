package com.hotelInterface.action.roomMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;

public class ActionExportRooms extends AAction implements IAction {


    @Override
    public ActionEnumResult execute() {

        try {
            getHotelController().exportRoom();
            getPrinter().printString("All rooms was added");
            return ActionEnumResult.TRUE;
        } catch (IllegalArgumentException e) {
            getPrinter().printString("File with that name wasn't found");
            return ActionEnumResult.TRUE;
        }
    }
}
