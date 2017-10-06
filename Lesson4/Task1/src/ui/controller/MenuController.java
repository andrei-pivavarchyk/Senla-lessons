package ui.controller;


import Storage.*;
import entity.Guest;
import services.*;
import ui.View.MainMenuView;
import ui.View.guestView.AllGuestsView;
import ui.model.ViewModel;
import ui.model.menuItem.GuestMenuItem.GuestMenuItem;
import ui.model.menuItem.GuestMenuItem.ShowAllGuestsItem;
import ui.model.menuItem.RoomMenuItem.RoomMenuItem;
import ui.model.menuItem.ServiceMenuItem.ServiceMenuItem;

import java.util.ArrayList;

import static sun.font.FontUtilities.isWindows;

public class MenuController {


    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;

    public MenuController() {

        IRoomStorage roomStorage = new RoomStorage();
        IGuestStorage guestStorage = new GuestStorage();
        IServiceStorage serviceStorage = new ServiceStorage();
        IGuestServiceStorage guestServiceStorage = new GuestServiceStorage();
        IGuestRoomInfoStorage guestRoomInfoStorage = new GuestRoomInfoStorage();

        this.roomService = new RoomService(roomStorage, guestRoomInfoStorage, guestStorage);
        this.guestSerice = new GuestService(guestRoomInfoStorage);
        this.serviceService = new ServiceService(guestServiceStorage, serviceStorage);
        this.printerService = new PrinterService();

    }




    public void showMainMenu() {


        GuestMenuItem menuItem1 = new GuestMenuItem(1, "Guest menu ", this);
        RoomMenuItem menuItem2 = new RoomMenuItem(2, "Room menu", this);
        ServiceMenuItem menuItem3 = new ServiceMenuItem(3, "Service menu", this);
        ViewModel mainMenuViewModel = new ViewModel("Main Menu");
        mainMenuViewModel.menuItems.add(menuItem1);
        mainMenuViewModel.menuItems.add(menuItem2);
        mainMenuViewModel.menuItems.add(menuItem3);
        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel);
        mainMenuView.act();
    }


    public void showGuestMenu() {


        ShowAllGuestsItem menuItem1 = new ShowAllGuestsItem(4, "Show all guests list ", this);
        RoomMenuItem menuItem2 = new RoomMenuItem(5, "Show some guest information", this);
        ViewModel mainMenuViewModel = new ViewModel("Guest Menu");
        mainMenuViewModel.menuItems.add(menuItem1);
        mainMenuViewModel.menuItems.add(menuItem2);
        MainMenuView mainMenuView = new MainMenuView(mainMenuViewModel);
        mainMenuView.act();

    }

     public void showAllGuests(){
         ArrayList<Guest> allGuests=new ArrayList<Guest>();
         allGuests=this.guestSerice.getAllGuests();
         System.out.println(allGuests);
         AllGuestsView allGuestsView=new AllGuestsView(allGuests);
         allGuestsView.act();
     }






    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void readRoomsFromFile(String path) {

        ReadFromFileService readFromFileService = new ReadFromFileService(roomService);
        readFromFileService.readRooms(path);

    }
}
