package action;

import controller.HotelController;
import entity.ActionEnumResult;
import service.MainService;

/**
 * Created by андрей on 11.10.2017.
 */
public class ActionShowServiceMenu implements IAction{
    private HotelController hotelController=MainService.getHotelController();

    @Override
    public ActionEnumResult execute() {
        return null;
    }
}
