package ui.action.roomMenuAction;

import hotel.controller.HotelController;
import ui.action.AAction;
import ui.entity.ActionEnumResult;
import ui.action.IAction;
import hotel.entity.Room;
import ui.service.MainService;
import hotel.services.PrinterService;

import java.util.ArrayList;

public class ActionShowFreeRoomsSortedByCost extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        ArrayList<Room> roomList = getHotelController().getRoomService().getFreeRooms();
        roomList = getHotelController().getRoomService().getArrayRoomCostSorting(roomList);
        getPrinter().printRooms(roomList);
        return ActionEnumResult.TRUE;
    }
}
