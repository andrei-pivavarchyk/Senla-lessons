package com.hotelInterface.action.roomMenuAction;



import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.queryService.hotelEntity.Guest;
import com.queryService.hotelEntity.Room;
import java.util.List;

public class ActionAddGuestToRoom extends AAction implements IAction {

    @Override
    public ActionEnumResult execute() {

       List<Room> allFreeRooms= getClientService().getFreeRooms();
            getPrinter().printRooms(allFreeRooms);

        //all free rooms was printed


        getPrinter().printString("Enter room number");
        int freeRoomsCount = getClientService().getFreeRooms().size();
        Room room;
        int roomNumber = 0;
        Boolean getRoom = false;
        while (getRoom.equals(false)) {
            roomNumber = getConsoleService().getNumber();
            if (roomNumber <= freeRoomsCount && roomNumber > 0) {
                room = getClientService().getRoomByNumber(roomNumber);
                getRoom = true;
            } else {
                getPrinter().printString("Try again");
            }
        }


        getPrinter().printString("Enter guest name");
        String name = getConsoleService().getString();
        getPrinter().printString("Enter guest surname");
        String surname = getConsoleService().getString();
        getPrinter().printString("Enter guest id");
        int id = getConsoleService().getNumber();
        Guest guest = new Guest(id, name, surname);
        getPrinter().printString("Enter guest departure year");
        int year = getConsoleService().getNumber();
        getPrinter().printString("Enter guest departure month");
        int month = getConsoleService().getNumber();
        getPrinter().printString("Enter guest departure day");
        int day = getConsoleService().getNumber();

        getClientService().addGuest(roomNumber,guest,year,month,day);


        return ActionEnumResult.TRUE;
    }
}
