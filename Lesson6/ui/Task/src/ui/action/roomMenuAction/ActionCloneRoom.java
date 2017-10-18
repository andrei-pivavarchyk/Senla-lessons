package ui.action.roomMenuAction;


import hotel.controller.HotelController;
import hotel.entity.Room;
import hotel.services.PrinterService;
import ui.action.IAction;
import ui.entity.ActionEnumResult;
import ui.service.ConsoleService;
import ui.service.MainService;

import java.util.ArrayList;
import java.util.List;

public class ActionCloneRoom implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();

    @Override
    public ActionEnumResult execute() {


        List<Room> roomList = hotelController.getRoomService().getAllRooms();
        printer.printRooms(roomList);

        printer.printString("Enter room number");

        Room cloneRoom = hotelController.cloneRoom(getRoomByNumber());

        printer.printString("Do u want to change clone room? Press Y or N");
        String string = this.consoleService.getString();
        if (string.equals("Y")) {

            printer.printString("Enter room number");
            int number = consoleService.getNumber();
            printer.printString("Enter room cost");
            int cost = consoleService.getNumber();
            printer.printString("Enter room capacity");
            int capacity = consoleService.getNumber();
            printer.printString("Enter room stars");
            int stars = consoleService.getNumber();
            cloneRoom.setCost(cost);
            cloneRoom.setCapacity(capacity);
            cloneRoom.setNumber(number);
            cloneRoom.setStars(stars);
            hotelController.getRoomService().addRoom(cloneRoom);
        } else if (string.equals("N")) {

        } else {
            printer.printString("Try again");
        }

        return ActionEnumResult.TRUE;
    }

    public Room getRoomByNumber() {

        int allRoomsCount = hotelController.getRoomService().getAllRooms().size();
        Room room = null;
        int roomNumber = 0;
        Boolean getRoom = false;
        while (getRoom.equals(false)) {
            roomNumber = consoleService.getNumber();
            if (roomNumber <= allRoomsCount && roomNumber > 0) {
                room = hotelController.getRoomService().getRoomByNumber(roomNumber);
                getRoom = true;
            } else {
                printer.printString("Try again!!!");
            }
        }
        return room;
    }


}
