package action.serviceMenuAction;

import action.IAction;
import controller.HotelController;
import entity.ActionEnumResult;
import entity.Guest;
import entity.GuestServiceInfo;
import service.ConsoleService;
import service.MainService;
import services.PrinterService;

import java.util.ArrayList;

public class ActionShowGuestServices implements IAction {
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
