package com.hotelInterface.action.roomMenuAction;



import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.entity.Room;

import java.util.List;

public class ActionCloneRoom extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        List<Room> roomList =  getClientService().getAllRooms();
        getPrinter().printRooms(roomList);

        getPrinter().printString("Enter room number");

        Room cloneRoom =  getClientService().clonerRoom(getRoomByNumber());

        getPrinter().printString("Do u want to change clone room? Press Y or N");
        String string = this.getConsoleService().getString();
        if (string.equals("Y")) {

            getPrinter().printString("Enter room number");
            int number = getConsoleService().getNumber();
            getPrinter().printString("Enter room cost");
            int cost = getConsoleService().getNumber();
            getPrinter().printString("Enter room capacity");
            int capacity = getConsoleService().getNumber();
            getPrinter().printString("Enter room stars");
            int stars = getConsoleService().getNumber();
            cloneRoom.setCost(cost);
            cloneRoom.setCapacity(capacity);
            cloneRoom.setNumber(number);
            cloneRoom.setStars(stars);
            getClientService().addRoom(cloneRoom);
        } else if (string.equals("N")||string.equals("n")) {
            getClientService().addRoom(cloneRoom);

        } else {
            getPrinter().printString("Try again");
        }

        return ActionEnumResult.TRUE;
    }

    public Room getRoomByNumber() {

        int allRoomsCount = getClientService().getAllRooms().size();
        Room room = null;
        int roomNumber = 0;
        Boolean getRoom = false;
        while (getRoom.equals(false)) {
            roomNumber = getConsoleService().getNumber();
            if (roomNumber <= allRoomsCount && roomNumber > 0) {
                room = getClientService().getRoomByNumber(roomNumber);
                getRoom = true;
            } else {
                getPrinter().printString("Try again!!!");
            }
        }
        return room;


    }
}
