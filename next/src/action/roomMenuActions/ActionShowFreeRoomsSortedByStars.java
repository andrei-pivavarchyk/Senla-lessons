package action.roomMenuActions;

import entity.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;

public class ActionShowFreeRoomsSortedByStars implements IAction {
    private HotelController hotelController = MainService.getHotelController();
    @Override
    public ActionEnumResult execute() {
        hotelController.printFreeRoomsByStars();
        return ActionEnumResult.TRUE;
    }
}
