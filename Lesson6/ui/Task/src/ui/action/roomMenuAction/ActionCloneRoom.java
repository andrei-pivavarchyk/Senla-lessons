package ui.action.roomMenuAction;


import hotel.controller.HotelController;
import hotel.entity.Room;
import hotel.services.PrinterService;
import ui.action.AAction;
import ui.action.IAction;
import ui.entity.ActionEnumResult;
import ui.service.ConsoleService;
import ui.service.MainService;

import java.util.List;

public class ActionCloneRoom extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

        List<Room> roomList = getHotelController().getRoomService().getAllRooms();
        getPrinter().printRooms(roomList);

        getPrinter().printString("Enter room number");

        Room cloneRoom = getHotelController().cloneRoom(getRoomByNumber());

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
            getHotelController().getRoomService().addRoom(cloneRoom);
        } else if (string.equals("N")||string.equals("n")) {
            getHotelController().getRoomService().addRoom(cloneRoom);

        } else {
            getPrinter().printString("Try again");
        }

        return ActionEnumResult.TRUE;
    }

    public Room getRoomByNumber() {

        int allRoomsCount = getHotelController().getRoomService().getAllRooms().size();
        Room room = null;
        int roomNumber = 0;
        Boolean getRoom = false;
        while (getRoom.equals(false)) {
            roomNumber = getConsoleService().getNumber();
            if (roomNumber <= allRoomsCount && roomNumber > 0) {
                room = getHotelController().getRoomService().getRoomByNumber(roomNumber);
                getRoom = true;
            } else {
                getPrinter().printString("Try again!!!");
            }
        }
        return room;
    }
}