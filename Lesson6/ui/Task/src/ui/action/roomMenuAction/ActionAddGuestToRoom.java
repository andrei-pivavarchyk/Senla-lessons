package ui.action.roomMenuAction;


import ui.action.AAction;
import ui.action.IAction;

import ui.entity.ActionEnumResult;
import hotel.controller.HotelController;
import hotel.entity.Guest;
import hotel.entity.Room;
import hotel.services.PrinterService;
import ui.service.ConsoleService;
import ui.service.MainService;

import java.util.ArrayList;

public class ActionAddGuestToRoom extends AAction implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();


    @Override
    public ActionEnumResult execute() {

        ArrayList<Room> roomList=hotelController.getRoomService().getFreeRooms();
        printer.printRooms(roomList);

        printer.printString("Enter room number");
        int freeRoomsCount = hotelController.getRoomService().getFreeRooms().size();
        Room room;
        int roomNumber = 0;
        Boolean getRoom = false;
        while (getRoom.equals(false)) {
            roomNumber = consoleService.getNumber();
            if (roomNumber <= freeRoomsCount && roomNumber > 0) {
                room = hotelController.getRoomService().getRoomByNumber(roomNumber);
                getRoom = true;
            } else {
                printer.printString("Try again");
            }
        }


        printer.printString("Enter guest name");
        String name = consoleService.getString();
        printer.printString("Enter guest surname");
        String surname = consoleService.getString();
        printer.printString("Enter guest id");
        int id = consoleService.getNumber();
        Guest guest = new Guest(id, name, surname);
        printer.printString("Enter guest departure year");
        int year = consoleService.getNumber();
        printer.printString("Enter guest departure month");
        int month = consoleService.getNumber();
        printer.printString("Enter guest departure day");
        int day = consoleService.getNumber();

        hotelController.addGuest(roomNumber, guest, year, month, day);
        return ActionEnumResult.TRUE;

    }
}
