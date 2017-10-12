package action.roomMenuActions;

import action.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;

public class ActionShowAllRooms implements IAction {

    private HotelController hotelController = MainService.getHotelController();

    @Override
    public ActionEnumResult execute() {
        hotelController.printAllRooms();
        return ActionEnumResult.NEXT;
    }
}
