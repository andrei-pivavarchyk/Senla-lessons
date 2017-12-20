package com.hotelInterface.action;


import com.hotelInterface.entity.ActionEnumResult;

public class ActionPreviousMenu extends AAction implements IAction{
    @Override
    public ActionEnumResult execute() {
        return ActionEnumResult.PREVIOUS;
    }
}
