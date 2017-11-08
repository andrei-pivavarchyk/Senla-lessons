package com.hotelInterface.action.guestMenuAction;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;

import com.hotelInterface.entity.ActionEnumResult;

import com.queryService.ClientSocket;
import com.queryService.QueryData;
import com.queryService.hotelEntity.Guest;


import java.io.IOException;
import java.util.List;

public class ActionShowAllGuests extends AAction implements IAction {
    public ActionEnumResult execute() {

    List<Guest> allGuests=getClientService().getAllGuests();

            getPrinter().printGuests(allGuests);

        return ActionEnumResult.TRUE;
    }
}


