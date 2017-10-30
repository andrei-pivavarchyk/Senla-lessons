package com.hotelInterface.action.serviceMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.testHotel.controller.HotelController;
import com.hotelInterface.entity.ActionEnumResult;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;
import com.testHotel.entity.GuestServiceInfo;
import com.hotelInterface.service.ConsoleService;
import com.hotelInterface.service.MainService;
import com.testHotel.service.IPrinterService;
import com.testHotel.service.PrinterService;

import java.util.ArrayList;

public class ActionShowGuestServices extends AAction implements IAction {
    private IHotelController hotelController = MainService.getMainService().getHotelController();
    private IPrinterService printer = MainService.getMainService().getPrinterService();


    @Override
    public ActionEnumResult execute() {
        ArrayList<Guest> guestList = this.hotelController.getGuestSerice().getAllGuests();
        printer.printGuests(guestList);
        printer.printString("Choose guest/Enter number");
        int guestNumber = ConsoleService.getConsoleService().getNumberForMenu(guestList.size());
            Guest guest = guestList.get(guestNumber - 1);
            ArrayList<GuestServiceInfo> guestServiceList = this.hotelController.getServiceService().getAllGuestServicesInfo(guest);
            printer.printGuestServices(guestServiceList);
            return ActionEnumResult.TRUE;
    }
}
