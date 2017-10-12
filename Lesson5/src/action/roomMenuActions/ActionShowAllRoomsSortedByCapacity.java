package action.roomMenuActions;

import entity.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;


public class ActionShowAllRoomsSortedByCapacity implements IAction {
    private HotelController hotelController = MainService.getHotelController();
    @Override
    public ActionEnumResult execute() {
       hotelController.printRoomsSortingByCapacity();
        return ActionEnumResult.TRUE;
    }
}
