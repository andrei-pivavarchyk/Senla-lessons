package ui.action;

import hotel.controller.HotelController;
import ui.entity.ActionEnumResult;
import ui.service.MainService;

public class ActionShowGuestMenu extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        return ActionEnumResult.NEXT;
    }
}
