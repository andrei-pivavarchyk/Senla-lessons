package ui.action.roomMenuAction;

import hotel.controller.HotelController;
import ui.action.AAction;
import ui.entity.ActionEnumResult;
import ui.action.IAction;
import hotel.entity.Room;
import ui.service.MainService;
import hotel.services.PrinterService;

import java.util.List;

public class ActionShowAllRooms extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        List<Room> roomList = getHotelController().getRoomService().getAllRooms();
        getPrinter().printRooms(roomList);


        return ActionEnumResult.NEXT;
    }
}
