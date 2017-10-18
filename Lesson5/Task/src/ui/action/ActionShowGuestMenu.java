package ui.action;

import hotel.controller.HotelController;
import ui.entity.ActionEnumResult;
import ui.service.MainService;

public class ActionShowGuestMenu implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();


    @Override
    public ActionEnumResult execute() {
        return ActionEnumResult.NEXT;
    }
}
