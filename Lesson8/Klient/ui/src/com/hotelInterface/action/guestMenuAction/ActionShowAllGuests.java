package com.hotelInterface.action.guestMenuAction;

import com.QueryData.QueryData.QueryData;
import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;

import com.hotelInterface.entity.ActionEnumResult;

import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;

import java.util.List;

public class ActionShowAllGuests extends AAction implements IAction {
    public ActionEnumResult execute() {
        QueryData queryData = new QueryData();
        queryData.setSomeClass(IHotelController.class);
        queryData.setSomeMethod("getAllGuests");
        List<Guest> guestList = (List<Guest>) getClientSocket().start(queryData);

        getPrinter().printGuests(guestList);


        return ActionEnumResult.TRUE;
    }
}


