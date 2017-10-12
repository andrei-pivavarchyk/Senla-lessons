package action.roomMenuActions;

import entity.ActionEnumResult;
import action.IAction;
import controller.HotelController;
import service.MainService;

/**
 * Created by андрей on 12.10.2017.
 */
public class ActionShowFreeRoomsSortedByCapacity implements IAction{
    private HotelController hotelController = MainService.getHotelController();
    @Override
    public ActionEnumResult execute() {
        hotelController.printFreeRoomsByCapacity();
        return ActionEnumResult.TRUE;
    }
}
