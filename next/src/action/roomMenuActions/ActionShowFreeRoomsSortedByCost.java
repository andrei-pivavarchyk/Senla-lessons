package action.roomMenuActions;

import entity.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;

public class ActionShowFreeRoomsSortedByCost implements IAction{
    private HotelController hotelController = MainService.getHotelController();
    @Override
    public ActionEnumResult execute() {
        hotelController.printFreeRoomsByCost();
        return ActionEnumResult.TRUE;
    }
}
