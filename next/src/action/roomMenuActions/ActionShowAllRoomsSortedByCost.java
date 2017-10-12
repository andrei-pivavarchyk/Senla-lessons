package action.roomMenuActions;

import entity.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;

public class ActionShowAllRoomsSortedByCost implements IAction {
    private HotelController hotelController = MainService.getHotelController();
    @Override
    public ActionEnumResult execute() {
        hotelController.printRoomsSortingByCost();
        return ActionEnumResult.TRUE;
    }
}
