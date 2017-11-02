package com.hotelInterface.action.serviceMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;
import com.hotelInterface.service.ConsoleService;
import com.hotelInterface.service.StartHotelService;
import com.testHotel.service.IPrinterService;

import java.util.ArrayList;

public class ActionShowGuestServices extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {
        ArrayList<Guest> guestList = getHotelController().getGuestSerice().getAllGuests();
        getPrinter().printGuests(guestList);
        getPrinter().printString("Choose guest/Enter number");
        int guestNumber = ConsoleService.getConsoleService().getNumberForMenu(guestList.size());
        try {
            Guest guest = guestList.get(guestNumber - 1);
            ArrayList<GuestServiceInfo> guestServiceList = getHotelController().getServiceService().getAllGuestServicesInfo(guest);
            getPrinter().printGuestServices(guestServiceList);
            return ActionEnumResult.TRUE;
        } catch (IndexOutOfBoundsException e) {
            getLog().error(e.toString());
        }
        return ActionEnumResult.TRUE;
    }
}
