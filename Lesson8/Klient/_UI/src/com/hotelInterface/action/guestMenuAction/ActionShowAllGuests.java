package com.hotelInterface.action.guestMenuAction;
import com.entity.Guest;
import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;

import java.util.List;

public class ActionShowAllGuests extends AAction implements IAction {
    public ActionEnumResult execute() {

    List<Guest> allGuests=getClientService().getAllGuests();

            getPrinter().printGuests(allGuests);

        return ActionEnumResult.TRUE;
    }
}


