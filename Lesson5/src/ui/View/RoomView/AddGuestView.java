package ui.View.RoomView;


import entity.Guest;
import entity.Room;
import ui.Service.ConsoleService;
import ui.View.AbstractView;
import ui.Service.MainService;
import ui.model.ViewModel;

import java.util.List;

public class AddGuestView extends AbstractView {
    private List<Room> allRooms;
    private MainService controller;

    public AddGuestView(List<Room> allRooms, ViewModel model, MainService controller) {
        super(model);
        this.allRooms = allRooms;
        this.controller = controller;
    }

    public void addGuest() {

        int roomNumber = this.chooseRoom();
        if (roomNumber != 0) {
            Guest guest = this.createGuest();
            System.out.print("Enter year departure(example 2018)");
            int year = ConsoleService.getConsoleService().getNumber();
            System.out.print("Enter month departure(example 7)");
            int month = ConsoleService.getConsoleService().getNumber();
            System.out.print("Enter day departure(example 2)");
            int day = ConsoleService.getConsoleService().getNumber();
            this.controller.addGuest(roomNumber, guest, year, month, day);
            System.out.println("Guest Was Added");
        } else {
            this.showInformation();
            System.out.println("Enter correct room number");
            this.addGuest();
        }

    }

    public void showInformation() {
        int i = 1;
        for (Room room : allRooms) {
            System.out.println(i + " " + room);
        }
    }


    public int chooseRoom() {
        System.out.println("Enter room Number");
        int roomNumber = ConsoleService.getConsoleService().getNumberForView(allRooms.size());
        for (Room room : allRooms) {
            if (room.getNumber() == roomNumber) {
                return roomNumber;
            }
        }
        return 0;
    }


    public Guest createGuest() {
        System.out.print("Enter name");
        String name = ConsoleService.getConsoleService().getString();
        System.out.print("Enter surname");
        String surname = ConsoleService.getConsoleService().getString();
        Guest guest = new Guest(1, name, surname);
        return guest;

    }
}
