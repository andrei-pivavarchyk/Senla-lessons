/*package ui.Service;


import Storage.*;
import entity.Guest;
import entity.Room;
import entity.Service;
import services.*;
import ui.View.MainMenuView;
import ui.View.RoomView.AddGuestView;
import ui.View.RoomView.RoomView;
import ui.View.RoomView.ShowAllRoomsSortedByCostView;
import ui.View.RoomView.ShowAllRoomsView;
import ui.View.ServiceView.ServiceMenuView;
import ui.View.ServiceView.ShowAllServicesSortedByCostView;
import ui.View.ServiceView.ShowAllServicesView;
import ui.View.guestView.GuestMenuView;
import ui.View.guestView.ShowAllGuestsSortedByDateView;
import ui.View.guestView.ShowAllGuestsSortedByNameView;
import ui.View.guestView.ShowAllGuestsView;
import ui.menuItem.GuestMenuItem.ShowAllGuestsSortedByDepartureDateItem;

import ui.menuItem.GuestMenuItem.ShowAllGuestsSortedByNameItem;
import ui.menuItem.MainMenuItem;
import ui.menuItem.RoomMenuItem.*;
import ui.menuItem.ServiceMenuItem.ShowAllServiceSortedByCost;
import ui.menuItem.ServiceMenuItem.ShowAllServicesItem;
import ui.model.ViewModel;
import ui.menuItem.GuestMenuItem.GuestMenuItem;
import ui.menuItem.GuestMenuItem.ShowAllGuestsItem;
import ui.menuItem.ServiceMenuItem.ServiceMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {


    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;

    public MenuService() {

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

        MainMenuItem menuItem1 = new MainMenuItem(4, "Show mainMenu ", this);
        ShowAllGuestsItem menuItem2 = new ShowAllGuestsItem(4, "Show all guests list ", this);
        RoomMenuItem menuItem3 = new RoomMenuItem(5, "Show some guest information", this);
        ViewModel mainMenuViewModel = new ViewModel("Guest Menu");
        mainMenuViewModel.menuItems.add(menuItem1);
        mainMenuViewModel.menuItems.add(menuItem2);
        mainMenuViewModel.menuItems.add(menuItem3);
        GuestMenuView view = new GuestMenuView(mainMenuViewModel);
        view.act();

    }

     public void showAllGuestsMenu(){
         MainMenuItem menuItem1 = new MainMenuItem(4, "Show mainMenu ", this);
         ShowAllGuestsSortedByNameItem menuItem2 = new ShowAllGuestsSortedByNameItem(4, "Sort List By name ", this);
         ShowAllGuestsSortedByDepartureDateItem menuItem3 = new ShowAllGuestsSortedByDepartureDateItem(4, "Sort List By departure date ", this);
         ViewModel mainMenuViewModel = new ViewModel("Guest Menu");
         mainMenuViewModel.menuItems.add(menuItem1);
         mainMenuViewModel.menuItems.add(menuItem2);
         mainMenuViewModel.menuItems.add(menuItem3);

         ArrayList<Guest> allGuests=new ArrayList<Guest>();
         allGuests=this.guestSerice.getAllGuests();
         this.printerService.printGuests(allGuests);
         ShowAllGuestsView view=new ShowAllGuestsView(allGuests,mainMenuViewModel);
         view.act();
     }

     public void showAllGuestsSortedByName(){
         MainMenuItem menuItem1 = new  MainMenuItem(4, "Show mainMenu ", this);
         ShowAllGuestsItem menuItem2 = new ShowAllGuestsItem(4, "Show all guests ", this);
         ShowAllGuestsSortedByDepartureDateItem menuItem3 = new ShowAllGuestsSortedByDepartureDateItem(4, "Sort List By departure date ", this);
         ViewModel mainMenuViewModel = new ViewModel("Guest Menu");
         mainMenuViewModel.menuItems.add(menuItem1);
         mainMenuViewModel.menuItems.add(menuItem2);
         mainMenuViewModel.menuItems.add(menuItem3);

         ArrayList<Guest> allGuests=new ArrayList<Guest>();
         allGuests=this.guestSerice.getAllGuestsSortedByName();
         this.printerService.printGuests(allGuests);
         ShowAllGuestsSortedByNameView view=new  ShowAllGuestsSortedByNameView(allGuests,mainMenuViewModel);
         view.act();
     }
     public void showAllGuestsSortedByDepartureDate(){
         MainMenuItem menuItem1 = new  MainMenuItem(4, "Show mainMenu ", this);
         ShowAllGuestsItem menuItem2 = new ShowAllGuestsItem(4, "Show all guests ", this);
         ShowAllGuestsSortedByNameItem menuItem3 = new ShowAllGuestsSortedByNameItem(4, "Sort List By departure date ", this);
         ViewModel mainMenuViewModel = new ViewModel("Guest Menu");
         mainMenuViewModel.menuItems.add(menuItem1);
         mainMenuViewModel.menuItems.add(menuItem2);
         mainMenuViewModel.menuItems.add(menuItem3);

         ArrayList<Guest> allGuests=new ArrayList<Guest>();
         allGuests=this.guestSerice.getAllGuestsSortedByDateDeparture();
         this.printerService.printGuests(allGuests);
         ShowAllGuestsSortedByDateView view=new ShowAllGuestsSortedByDateView(allGuests,mainMenuViewModel);
         view.act();
     }


    public void serviceMenu(){

        MainMenuItem menuItem1 = new  MainMenuItem(4, "Show mainMenu ", this);
        ShowAllServicesItem menuItem2 = new ShowAllServicesItem(4, "Show all Services ", this);

        ViewModel mainMenuViewModel = new ViewModel("Service menu");
        mainMenuViewModel.menuItems.add(menuItem1);
        mainMenuViewModel.menuItems.add(menuItem2);
        ServiceMenuView serviceMenuView=new ServiceMenuView(mainMenuViewModel);
        serviceMenuView.act();
    }


    public void showAllServicesMenu(){
        MainMenuItem menuItem1 = new  MainMenuItem(4, "Show mainMenu ", this);
        ShowAllServiceSortedByCost menuItem2 = new  ShowAllServiceSortedByCost(4, "Show services by cost ", this);

        ViewModel mainMenuViewModel = new ViewModel("Show all services menu");
        mainMenuViewModel.menuItems.add(menuItem1);
        mainMenuViewModel.menuItems.add(menuItem2);

        ShowAllServicesView showAllServicesView=new ShowAllServicesView(mainMenuViewModel);

        List<Service> allServices=new ArrayList<Service>();
        allServices=this.serviceService.getServiceStorage().getAllEntities();
        this.printerService.printServices(allServices);
        showAllServicesView.act();

    }


    public void showAllServicesMenuSortedByCost(){
        MainMenuItem menuItem1 = new  MainMenuItem(4, "Show mainMenu ", this);
        ShowAllServicesItem menuItem2 = new ShowAllServicesItem(4, "Show all Services ", this);

        ViewModel mainMenuViewModel = new ViewModel("Show all services sorted By cost");
        mainMenuViewModel.menuItems.add(menuItem1);
        mainMenuViewModel.menuItems.add(menuItem2);
        ShowAllServicesSortedByCostView showAllServiceSortedByCostView=new ShowAllServicesSortedByCostView(mainMenuViewModel);

        List<Service> allServices=new ArrayList<Service>();
        allServices=this.serviceService.getAllServicesSortedByCost();
        this.printerService.printServices(allServices);
        showAllServiceSortedByCostView.act();


    }

public void roomMenu() {
    MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);
    AddGuestItem item2 = new AddGuestItem(1, "Add guest to room", this);
    ShowAllRoomsItem item3 = new ShowAllRoomsItem(1, "Show All rooms", this);
    ShowFreeRoomsItem item4=new ShowFreeRoomsItem(1, "Show free rooms", this);

    ViewModel model = new ViewModel("Room menu");
    model.menuItems.add(item1);
    model.menuItems.add(item2);
    model.menuItems.add(item3);
    model.menuItems.add(item4);

    RoomView roomView = new RoomView(model);
    roomView.act();
}



public void showAllRoomsMenu(){
    MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);
    ShowAllRoomsSortedByCapacityItem item2=new ShowAllRoomsSortedByCapacityItem(1, "Show rooms sorted by capacity", this);
    ShowAllRoomsSortedByCostItem item3=new ShowAllRoomsSortedByCostItem(1, "Show rooms sorted by cost", this);
    ShowAllRoomsSortedByStarsItem item4=new ShowAllRoomsSortedByStarsItem(1, "Show rooms sorted by stars", this);

    ViewModel model = new ViewModel("Show All rooms menu");
    model.menuItems.add(item1);
    model.menuItems.add(item2);
    model.menuItems.add(item3);
    model.menuItems.add(item4);

   List<Room> allRooms=this.roomService.getAllRooms();

    ShowAllRoomsView view=new ShowAllRoomsView(allRooms,model);
    view.showInformation();
    view.act();
}

public void showAllRoomsSortedByCost(){

    MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);
    ShowAllRoomsSortedByCapacityItem item2=new ShowAllRoomsSortedByCapacityItem(1, "Show rooms sorted by capacity", this);
    ShowAllRoomsSortedByStarsItem item3=new ShowAllRoomsSortedByStarsItem(1, "Show rooms sorted by stars", this);
    ViewModel model = new ViewModel("Show All rooms menu");
    model.menuItems.add(item1);
    model.menuItems.add(item2);
    model.menuItems.add(item3);

    List<Room> allRooms=this.roomService.getRoomCostSorting(this.roomService.getAllRooms());
    ShowAllRoomsSortedByCostView view=new ShowAllRoomsSortedByCostView(allRooms,model);
    view.showInformation();
    view.act();

}
    public void showAllRoomsSortedByCapacity(){

        MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);
        ShowAllRoomsSortedByCostItem item2=new ShowAllRoomsSortedByCostItem(1, "Show rooms sorted by cost", this);
        ShowAllRoomsSortedByStarsItem item3=new ShowAllRoomsSortedByStarsItem(1, "Show rooms sorted by stars", this);
        ViewModel model = new ViewModel("Show All rooms menu");
        model.menuItems.add(item1);
        model.menuItems.add(item2);
        model.menuItems.add(item3);

        List<Room> allRooms=this.roomService.getRoomCapacitySorting(this.roomService.getAllRooms());
        ShowAllRoomsView view=new ShowAllRoomsView(allRooms,model);
        view.showInformation();
        view.act();

    }

    public void showAllRoomsSortedByStars(){

        MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);
        ShowAllRoomsSortedByCostItem item2=new ShowAllRoomsSortedByCostItem(1, "Show rooms sorted by cost", this);
        ShowAllRoomsSortedByCapacityItem item3=new ShowAllRoomsSortedByCapacityItem(1, "Show rooms sorted by capacity", this);
        ViewModel model = new ViewModel("Show All rooms menu");
        model.menuItems.add(item1);
        model.menuItems.add(item2);
        model.menuItems.add(item3);

        List<Room> allRooms=this.roomService.getRoomStarsSorting(this.roomService.getAllRooms());
        ShowAllRoomsView view=new ShowAllRoomsView(allRooms,model);
        view.showInformation();
        view.act();

    }


    public void showFreeRoomsMenu(){
        MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);

        ViewModel model = new ViewModel("Show All rooms menu");
        model.menuItems.add(item1);

        List<Room> allRooms=this.roomService.getFreeRooms();
        ShowAllRoomsView view=new ShowAllRoomsView(allRooms,model);
        view.showInformation();
        view.act();
    }


        public void addGuestMenu(){
            MainMenuItem item1 = new  MainMenuItem(4, "Show mainMenu ", this);

            ViewModel model = new ViewModel("Add guest menu");
            model.menuItems.add(item1);

            List<Room> allRooms=this.roomService.getFreeRooms();
            AddGuestView view=new AddGuestView(allRooms,model);
            view.showInformation();

            Room room=view.shooseRoom();
            Guest guest=view.createGuest();

            System.out.print("Enter year departure(example:2018)");
            Scanner scanner1 = new Scanner(System.in);
            int year=  scanner1.nextInt();

            System.out.print("Enter month departure(example:5)");
            Scanner scanner2 = new Scanner(System.in);
            int month=  scanner2.nextInt();

            System.out.print("Enter day departure(example:7 or 31)");
            Scanner scanner3 = new Scanner(System.in);
            int day=  scanner3.nextInt();

            this.roomService.addGuest(room.getNumber(),guest,year,month,day);
            System.out.println("guest Was added ");
            this.showMainMenu();
        }





    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void readRoomsFromFile(String path) {

        ReadFromFileService readFromFileService = new ReadFromFileService(roomService);
        readFromFileService.readRooms(path);
    }
    public void addService(Service service) {
        this.serviceService.addService(service);
    }


}
*/