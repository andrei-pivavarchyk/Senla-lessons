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

    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();

    @Override
    public ActionEnumResult execute() {
        List<Room> roomList = hotelController.getRoomService().getAllRooms();
        printer.printRooms(roomList);


        return ActionEnumResult.NEXT;
    }
}
