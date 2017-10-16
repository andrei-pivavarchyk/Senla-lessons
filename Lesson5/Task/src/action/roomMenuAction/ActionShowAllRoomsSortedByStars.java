package action.roomMenuAction;

import controller.HotelController;
import entity.ActionEnumResult;
import action.IAction;
import entity.Room;
import service.MainService;
import services.PrinterService;

import java.util.ArrayList;

public class ActionShowAllRoomsSortedByStars implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer=MainService.getMainService().getPrinterService();

    @Override
    public ActionEnumResult execute() {
        ArrayList<Room> roomList= hotelController.getRoomService().getRoomStarsSorting();
        printer.printRooms(roomList);
        return ActionEnumResult.TRUE;
    }
}
