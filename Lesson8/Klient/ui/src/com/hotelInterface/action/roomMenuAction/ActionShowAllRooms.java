package com.hotelInterface.action.roomMenuAction;

import com.QueryData.QueryData.QueryData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.action.AAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.hotelInterface.action.IAction;
import com.hotelInterface.querySenderService.ClientSocket;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;

import java.io.IOException;
import java.util.List;

public class ActionShowAllRooms extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        QueryData queryData=new QueryData();
        queryData.setSomeClass(IHotelController.class);
        queryData.setSomeMethod("getAllRooms");



        String serverAnswer = ClientSocket.start(queryData);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<Room> allRooms = mapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            getPrinter().printRooms(allRooms);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ActionEnumResult.NEXT;
    }
}
