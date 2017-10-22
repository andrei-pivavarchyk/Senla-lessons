package ui.action.roomMenuAction;


import ui.action.AAction;
import ui.entity.ActionEnumResult;
import ui.action.IAction;

import hotel.controller.HotelController;
import hotel.entity.Room;
import hotel.services.PrinterService;
import ui.service.MainService;


import java.util.ArrayList;

public class ActionShowAllRoomsSortedByCost extends AAction implements IAction {
    @Override
    public ActionEnumResult execute() {

        ArrayList<Room> roomList = getHotelController().getRoomService().getRoomCostSorting();
        getPrinter().printRooms(roomList);
        return ActionEnumResult.TRUE;
    }
}
