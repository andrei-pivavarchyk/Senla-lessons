package com.hotelInterface.action.roomMenuAction;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.queryService.ClientSocket;
import com.queryService.QueryData;
import com.queryService.hotelEntity.Room;
import com.testHotel.controller.IHotelController;


import java.io.IOException;
import java.util.List;

public class ActionShowAllRooms extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {


            List<Room> allRooms =getClientService().getAllRooms();

            getPrinter().printRooms(allRooms);

        return ActionEnumResult.NEXT;
    }
}
