package action.guestMenuAction;

import action.IAction;
import controller.HotelController;
import entity.ActionEnumResult;
import entity.Guest;
import service.MainService;
import services.PrinterService;

import java.util.ArrayList;

public class ActionShowAllGuests implements IAction{
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();

    public  ActionEnumResult execute(){
       ArrayList<Guest> guestList= hotelController.getGuestSerice().getAllGuests();
       printer.printGuests(guestList);
        return ActionEnumResult.TRUE;
    }
}


