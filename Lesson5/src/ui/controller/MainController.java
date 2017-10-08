package ui.controller;


import Storage.*;
import entity.Guest;
import entity.Room;
import entity.Service;
import services.*;
import ui.Service.ModelCreationService;
import ui.View.RoomView.ShowRoomsView;
import ui.View.ServiceView.ShowAllServicesView;
import ui.View.ViewItems;
import ui.View.guestView.ShowAllGuestsView;
import ui.model.ViewModel;
import ui.storeFactory.GuestStoreFactory;
import ui.storeFactory.RoomStoreFactory;
import ui.storeFactory.ServiceStoreFactory;

import java.util.ArrayList;
import java.util.List;

public class MainController extends AController {

    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;


    private ModelCreationService modelService;
    public MainController(){

        this.modelService=new ModelCreationService(this);

        IRoomStorage roomStorage = new RoomStoreFactory().createRoomStorage();
        IGuestStorage guestStorage = new GuestStoreFactory().createGuestStorage();
        IServiceStorage serviceStorage = new ServiceStoreFactory().createServiceStorage();

        IGuestServiceStorage guestServiceStorage = new GuestServiceStorage();
        IGuestRoomInfoStorage guestRoomInfoStorage = new GuestRoomInfoStorage();
        this.roomService = new RoomService(roomStorage, guestRoomInfoStorage, guestStorage);
        this.guestSerice = new GuestService(guestRoomInfoStorage);
        this.serviceService = new ServiceService(guestServiceStorage, serviceStorage);
        this.printerService = new PrinterService();

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

        ArrayList<Room> allRooms=this.roomService.getArrayRoomCostSorting();
        ViewModel model=this.modelService.createModelForShowAllRoomsSortedByCostMenu();
        ShowRoomsView view=new ShowRoomsView( allRooms,model);
        view.showInformation();

        view.act();
    }

    public void showAllRoomsSortedByCapacityMenu(){
        ArrayList<Room> allRooms=this.roomService.getArrayRoomCapacitySorting();
        ViewModel model=this.modelService.createModelForShowAllRoomsSortedByCapacityMenu();
        ShowRoomsView view=new ShowRoomsView( allRooms,model);
        view.showInformation();
        view.act();
    }

    public void showAllRoomsSortedByStarsMenu(){

        ArrayList<Room> allRooms=this.roomService.getArrayRoomStarsSorting();
        ViewModel model=this.modelService.createModelForShowAllRoomsSortedByStarsMenu();
        ShowRoomsView view=new ShowRoomsView( allRooms,model);
        view.showInformation();
        view.act();
    }

    //Free rooms
    public void showAllFreeRoomsMenu(){

        ViewModel model=this.modelService.createModelForShowAllFreeRoomsMenu();
        ShowRoomsView view=new ShowRoomsView( this.roomService.getFreeRooms(),model);
        view.showInformation();
        view.act();
    }

    public void showAllFreeRoomsSortedByCostMenu(){

       ArrayList<Room> allRooms=this.roomService.getFreeRooms();
       allRooms= this.roomService.getArrayRoomCostSorting(allRooms);

        ViewModel model=this.modelService.createModelForshowAllFreeRoomsSortedByCostMenu();
        ShowRoomsView view=new ShowRoomsView( allRooms,model);
        view.showInformation();
        view.act();
    }

    public void showAllFreeRoomsSortedByCapacityMenu(){

        ArrayList<Room> allRooms=this.roomService.getFreeRooms();
        allRooms= this.roomService.getRoomCapacitySorting(allRooms);

        ViewModel model=this.modelService.createModelForShowAllFreeRoomsSortedByCapacityMenu();
        ShowRoomsView view=new ShowRoomsView( allRooms,model);
        view.showInformation();
        view.act();
    }
    public void showAllFreeRoomsSortedByStarsMenu(){

        ArrayList<Room> allRooms=this.roomService.getFreeRooms();
        allRooms= this.roomService.getRoomStarsSorting(allRooms);

        ViewModel model=this.modelService.createModelForShowAllFreeRoomsSortedByStarsMenu();
        ShowRoomsView view=new ShowRoomsView( allRooms,model);
        view.showInformation();
        view.act();
    }



    public void showGuestMenu(){

        ViewModel model=this.modelService.createModelForShowGuestMenu();
        ViewItems view=new ViewItems(model);
        view.act();
    }


    public void showAllGuestsMenu(){
        ViewModel model=this.modelService.createModelForShowAllGuestsMenu();
        ShowAllGuestsView view=new ShowAllGuestsView(this.guestSerice.getAllGuests(),model);
        view.showInformation();
        view.act();
    }

    public void showAllGuestsSortedByNameMenu(){

        ArrayList<Guest> allGuests=this.guestSerice.getAllGuestsSortedByName();
        ViewModel model=this.modelService. createModelForShowAllGuestsSortedByName();
        ShowAllGuestsView view=new ShowAllGuestsView( allGuests,model);
        view.showInformation();
        view.act();

    }
    public void showAllGuestsSortedByDepartureDate(){

        ArrayList<Guest> allGuests=this.guestSerice.getAllGuestsSortedByDateDeparture();
        ViewModel model=this.modelService.createModelForShowAllGuestsSortedByDepartureDate();
        ShowAllGuestsView view=new ShowAllGuestsView( allGuests,model);
        view.showInformation();
        view.act();

    }

    public void showAllServicesMenu(){
        ArrayList<Service> allServices=new ArrayList<Service>(this.serviceService.getAllHotelServices());
        ViewModel model=this.modelService.createModelForshowAllServicesMenu();
        ShowAllServicesView view=new ShowAllServicesView(allServices,model);
    }

    public void showAllServicesSortedByCost(){
        ViewModel model=this.modelService.createModelForshowAllServicesSortedByCost();
    }






























    public void showServiceMenu(){}



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
