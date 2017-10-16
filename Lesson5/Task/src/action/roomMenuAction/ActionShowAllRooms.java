package action.roomMenuAction;

import controller.HotelController;
import entity.ActionEnumResult;
import action.IAction;
import entity.Room;
import service.MainService;
import services.PrinterService;

import java.util.List;

public class ActionShowAllRooms implements IAction {

    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();

    @Override
    public ActionEnumResult execute() {
        List<Room> roomList = hotelController.getRoomService().getAllRooms();
        printer.printRooms(roomList);


        return ActionEnumResult.NEXT;
    }
}
