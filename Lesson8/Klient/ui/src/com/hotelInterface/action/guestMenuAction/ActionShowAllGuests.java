package com.hotelInterface.action.guestMenuAction;

import com.QueryData.QueryData.QueryData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;

import com.hotelInterface.entity.ActionEnumResult;

import com.hotelInterface.querySenderService.ClientSocket;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;

import java.io.IOException;
import java.util.List;

public class ActionShowAllGuests extends AAction implements IAction {
    public ActionEnumResult execute() {
        QueryData queryData = new QueryData();
        queryData.setSomeClass(IHotelController.class);
        queryData.setSomeMethod("getAllGuests");

        String serverAnswer = ClientSocket.start(queryData);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Guest> allGuests = mapper.readValue(serverAnswer, new TypeReference<List<Guest>>() {
            });
            getPrinter().printGuests(allGuests);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ActionEnumResult.TRUE;
    }
}


