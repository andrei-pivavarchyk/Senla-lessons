package ui.action.guestMenuAction;

import ui.action.AAction;
import ui.action.IAction;

import ui.entity.ActionEnumResult;

import hotel.controller.HotelController;
import hotel.entity.Guest;
import hotel.services.PrinterService;
import ui.service.MainService;


import java.util.ArrayList;

public class ActionShowAllGuests extends AAction implements IAction{
    public  ActionEnumResult execute(){
       ArrayList<Guest> guestList=  getHotelController().getGuestSerice().getAllGuests();
       getPrinter().printGuests(guestList);
        return ActionEnumResult.TRUE;
    }
}


