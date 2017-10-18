package ui.action.serviceMenuAction;

import ui.action.AAction;
import ui.action.IAction;
import hotel.controller.HotelController;
import ui.entity.ActionEnumResult;
import hotel.entity.Guest;
import hotel.entity.GuestServiceInfo;
import ui.service.ConsoleService;
import ui.service.MainService;
import hotel.services.PrinterService;

import java.util.ArrayList;

public class ActionShowGuestServices extends AAction implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();


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
