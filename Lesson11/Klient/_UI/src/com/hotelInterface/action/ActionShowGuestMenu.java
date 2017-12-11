package com.hotelInterface.action;

import com.hotelInterface.entity.ActionEnumResult;

public class ActionShowGuestMenu extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        return ActionEnumResult.NEXT;
    }
}
