package ui.action.roomMenuAction;


import ui.entity.ActionEnumResult;
import ui.action.IAction;

import hotel.controller.HotelController;
import hotel.entity.Room;
import hotel.services.PrinterService;
import ui.service.MainService;


import java.util.ArrayList;

public class ActionShowAllRoomsSortedByCost implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer=MainService.getMainService().getPrinterService();

    @Override
    public ActionEnumResult execute() {

        ArrayList<Room> roomList= hotelController.getRoomService().getRoomCostSorting();
        printer.printRooms(roomList);
        return ActionEnumResult.TRUE;
    }
}
