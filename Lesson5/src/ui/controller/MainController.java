package ui.controller;


import Storage.*;
import entity.Guest;
import entity.Room;
import entity.Service;
import services.*;
import ui.Service.ModelCreationService;
import ui.View.RoomView.ShowRoomsView;
import ui.View.ViewItems;
import ui.model.ViewModel;

import java.util.ArrayList;

public class MainController {

    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;


    private ModelCreationService modelService;
    public MainController(){

        this.modelService=new ModelCreationService(this);

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

public void ss(){
        System.out.println(this.roomService.getAllRooms());

}

    public void showMainMenu()  {
        ViewModel model=this.modelService.createModelForMainMenu();
        ViewItems view=new ViewItems(model);
        view.act();
    }

    public void showRoomMenu(){
        ViewModel model=this.modelService.createModelForRoomMenu();
        ViewItems view=new ViewItems(model);
        view.act();
    }


    public void showAllRoomsMenu(){
        ViewModel model=this.modelService.createModelForShowAllRoomsMenu();
        ShowRoomsView view=new ShowRoomsView( this.roomService.getAllRooms(),model);
        view.showInformation();
        view.act();
    }

    public void showAllRoomsSortedByCostMenu(){
        ArrayList<Room> allRooms=new ArrayList<Room>();
        ViewModel model=this.modelService.createModelForShowAllRoomsSortedByCostMenu();
        ShowRoomsView view=new ShowRoomsView( this.roomService.getRoomCostSorting(allRooms),model);
        view.showInformation();
        view.act();
    }

    public void showAllRoomsSortedByCapacityMenu(){
        ArrayList<Room> allRooms=new ArrayList<Room>();
        ViewModel model=this.modelService.createModelForShowAllRoomsSortedByCapacityMenu();
        ShowRoomsView  view=new ShowRoomsView ( this.roomService.getRoomCapacitySorting(allRooms),model);
        view.showInformation();
        view.act();
    }

    public void showAllRoomsSortedByStarsMenu(){

        ArrayList<Room> allRooms=new ArrayList<Room>();
        ViewModel model=this.modelService.createModelForShowAllRoomsSortedByStarsMenu();
        ShowRoomsView  view=new ShowRoomsView ( this.roomService.getRoomStarsSorting(allRooms),model);
        view.showInformation();
        view.act();
    }






    public void showGuestMenu(){}

    public void showServiceMenu(){}

    public void showAllGuestsMenu(){}

    public void showAllGuestsSortedByDepartureDateMenu(){}



















    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void addService(Service service) {
        this.serviceService.addService(service);
    }
    public void readRoomsFromFile(String path) {

        ReadFromFileService readFromFileService = new ReadFromFileService(roomService);
        readFromFileService.readRooms(path);
    }

}
