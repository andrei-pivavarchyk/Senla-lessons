package com.hotelInterface.action.guestMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;

import com.hotelInterface.entity.ActionEnumResult;

import com.testHotel.entity.Guest;


import java.util.ArrayList;

public class ActionShowAllGuests extends AAction implements IAction {
    public  ActionEnumResult execute(){
       ArrayList<Guest> guestList=  getHotelController().getGuestSerice().getAllGuests();
       getPrinter().printGuests(guestList);
        return ActionEnumResult.TRUE;
    }
}


