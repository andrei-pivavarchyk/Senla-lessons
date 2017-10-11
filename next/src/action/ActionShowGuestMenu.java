package action;

import controller.HotelController;
import service.MainService;

/**
 * Created by андрей on 11.10.2017.
 */
public class ActionShowGuestMenu implements IAction {
    private HotelController hotelController=MainService.getHotelController();


    @Override
    public ActionEnumResult execute() {
        return null;
    }
}
