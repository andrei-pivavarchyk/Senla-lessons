package action;

import controller.HotelController;
import entity.ActionEnumResult;
import service.MainService;

public class ActionShowGuestMenu implements IAction {
    private HotelController hotelController=MainService.getHotelController();


    @Override
    public ActionEnumResult execute() {
        return null;
    }
}
