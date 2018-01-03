package com.hotelInterface.action.serviceMenuAction;



import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.service.ConsoleService;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ActionShowGuestServices extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        List<Guest> guestList = getClientService().getAllGuests();
        getPrinter().printGuests(guestList);
        getPrinter().printString("Choose guest/Enter number");
        int guestNumber = ConsoleService.getConsoleService().getNumberForMenu(guestList.size());
        try {
            Guest guest = guestList.get(guestNumber - 1);
            List<GuestServiceInfo> guestServiceList = getClientService().getAllGuestServicesInfo(guest);
            getPrinter().printGuestServices(guestServiceList);
            return ActionEnumResult.TRUE;
        } catch (IndexOutOfBoundsException e) {
            getLog().error(e.toString());
        }
        return ActionEnumResult.TRUE;
    }
}
