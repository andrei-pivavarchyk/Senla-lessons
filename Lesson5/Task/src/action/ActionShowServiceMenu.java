package action;

import controller.HotelController;
import entity.ActionEnumResult;
import service.MainService;

public class ActionShowServiceMenu implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();

    @Override
    public ActionEnumResult execute() {
        return ActionEnumResult.NEXT;
    }
}
