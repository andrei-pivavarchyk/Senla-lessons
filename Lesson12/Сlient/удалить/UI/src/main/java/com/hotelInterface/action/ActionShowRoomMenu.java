package com.hotelInterface.action;

import com.hotelInterface.entity.ActionEnumResult;

public class ActionShowRoomMenu extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        return ActionEnumResult.NEXT;
    }
}
