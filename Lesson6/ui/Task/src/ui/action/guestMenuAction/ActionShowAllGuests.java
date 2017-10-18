package ui.action.guestMenuAction;

import ui.action.IAction;

import ui.entity.ActionEnumResult;

import hotel.controller.HotelController;
import hotel.entity.Guest;
import hotel.services.PrinterService;
import ui.service.MainService;


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


