package ui.controller;


import entity.Guest;
import entity.Room;
import entity.Service;
import services.*;
import ui.Service.LoggerService;

import ui.Service.MainService;
import ui.View.RoomView.AddGuestView;
import ui.View.RoomView.ShowRoomsView;
import ui.View.ServiceView.ServiceMenuView;
import ui.View.ServiceView.ShowAllServicesView;
import ui.View.ViewItems;
import ui.View.guestView.ShowAllGuestsView;
import ui.menuItem.Item;
import ui.model.ViewModel;

import java.util.ArrayList;

public class MenuController {

    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestService;
    private PrinterService printerService;
    private MainService mainService;

    public MenuController() {

        this.mainService = new MainService();
        this.serviceService=mainService.getServiceService();
        this.roomService=mainService.getRoomService();
        this.guestService=mainService.getGuestSerice();
        this.printerService=mainService.getPrinterService();

    }


    public void showMainMenu() {
        LoggerService.getLoggerService().logInfo("Program start");

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show guest menu", this, "showGuestMenu");
        Item item3 = new Item("Show room menu", this, "showRoomMenu");
        Item item4 = new Item("Show service menu", this, "showServiceMenu");

        ViewModel model = new ViewModel("MAIN MENU_**************_-_");
        model.addItem(item1);
        model.addItem(item2);
        model.addItem(item3);
        model.addItem(item4);

        ViewItems view = new ViewItems(model);
        view.act();
    }

    //Room menu

    public void showRoomMenu() {
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");

        Item item2 = new Item("add guest", this, "addGuestMenu");
        Item item3 = new Item("show all rooms", this, "showAllRoomsMenu");
        Item item4 = new Item("show free rooms", this, "showAllFreeRoomsMenu");
        ViewModel viewModel = new ViewModel("ROOM MENU_**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);

        ViewItems view = new ViewItems(viewModel);
        view.act();
    }


    public void addGuestMenu() {
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        ViewModel viewModel = new ViewModel("ADD GUEST MENU**************_-_");
        viewModel.addItem(item1);
        AddGuestView view = new AddGuestView(this.roomService.getFreeRooms(), viewModel, mainService);
        view.showInformation();
        view.addGuest();
        view.act();
    }


    public void showAllRoomsMenu() {
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all rooms sorted by Cost", this, "showAllRoomsSortedByCostMenu");
        Item item3 = new Item("show all rooms sorted by Stars", this, "showAllRoomsSortedByCapacityMenu");
        Item item4 = new Item("show all rooms sorted by capacity", this, "showAllRoomsSortedByStarsMenu");

        ViewModel viewModel = new ViewModel("ALL ROOMS MENU_**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);
        ShowRoomsView view = new ShowRoomsView(this.roomService.getAllRooms(), viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllRoomsSortedByCostMenu() {

        ArrayList<Room> allRooms = this.roomService.getRoomCostSorting();
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all rooms sorted by Stars", this, "showAllRoomsSortedByStarsMenu");
        Item item3 = new Item("show all rooms sorted by capacity", this, "showRoomsSortedByCapacityMenu");

        ViewModel viewModel = new ViewModel("ALL ROOMS SORTED BY COST MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowRoomsView view = new ShowRoomsView(allRooms, viewModel);
        view.showInformation();

        view.act();
    }

    public void showAllRoomsSortedByCapacityMenu() {
        ArrayList<Room> allRooms = this.roomService.getRoomCapacitySorting();
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all rooms sorted by Stars", this, "showRoomsSortedByStars");
        Item item3 = new Item("show all rooms sorted by Cost", this, "showRoomsSortedByCost");

        ViewModel viewModel = new ViewModel("ALL ROOMS SORTED BY CAPACITY MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowRoomsView view = new ShowRoomsView(allRooms, viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllRoomsSortedByStarsMenu() {

        ArrayList<Room> allRooms = this.roomService.getRoomStarsSorting();
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all rooms sorted by Cost", this, "showRoomsSortedByCostMenu");
        Item item3 = new Item("show all rooms sorted by capacity", this, "showAllRoomsSortedByCapacityMenu");

        ViewModel viewModel = new ViewModel("ALL ROOMS SORTED BY STARS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowRoomsView view = new ShowRoomsView(allRooms, viewModel);
        view.showInformation();
        view.act();
    }

    //Free rooms
    public void showAllFreeRoomsMenu() {

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all free rooms sorted by Cost", this, "showAllFreeRoomsSortedByCostMenu");
        Item item3 = new Item("show all free rooms sorted by Stars", this, "showAllFreeRoomsSortedByCapacityMenu");
        Item item4 = new Item("show all free rooms sorted by capacity", this, "showAllFreeRoomsSortedByStarsMenu");

        ViewModel viewModel = new ViewModel("ALL FREE ROOMS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);
        ShowRoomsView view = new ShowRoomsView(this.roomService.getFreeRooms(), viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllFreeRoomsSortedByCostMenu() {

        ArrayList<Room> allRooms = this.roomService.getFreeRooms();
        allRooms = this.roomService.getArrayRoomCostSorting(allRooms);

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all free rooms sorted by Stars", this, "showAllFreeRoomsSortedByCapacityMenu");
        Item item3 = new Item("show all free rooms sorted by capacity", this, "showAllFreeRoomsSortedByStarsMenu");

        ViewModel viewModel = new ViewModel("ALL FREE ROOMS  SORTED BY COST MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowRoomsView view = new ShowRoomsView(allRooms, viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllFreeRoomsSortedByCapacityMenu() {

        ArrayList<Room> allRooms = this.roomService.getFreeRooms();
        allRooms = this.roomService.getArrayRoomCapacitySorting(allRooms);

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all rooms sorted by Stars", this, "showAllFreeRoomsSortedByStarsMenu");
        Item item3 = new Item("show all rooms sorted by Cost", this, "showAllFreeRoomsSortedByCostMenu");

        ViewModel viewModel = new ViewModel("ALL ROOMS SORTED BY CAPACITY MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowRoomsView view = new ShowRoomsView(allRooms, viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllFreeRoomsSortedByStarsMenu() {

        ArrayList<Room> allRooms = this.roomService.getFreeRooms();
        allRooms = this.roomService.getArrayRoomStarsSorting(allRooms);

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all rooms sorted by Cost", this, "showAllFreeRoomsSortedByCostMenu");
        Item item3 = new Item("show all rooms sorted by capacity", this, "showAllFreeRoomsSortedByCapacityMenu");

        ViewModel viewModel = new ViewModel("ALL FREE ROOMS SORTED BY STARS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowRoomsView view = new ShowRoomsView(allRooms, viewModel);
        view.showInformation();
        view.act();
    }


    public void showGuestMenu() {

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all guests", this, "showAllGuestsMenu");
        ViewModel viewModel = new ViewModel("GUEST MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        ViewItems view = new ViewItems(viewModel);
        view.act();
    }

    public void showAllGuestsMenu() {
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");

        Item item2 = new Item("show all guests sorted by departure date", this, "showAllGuestsSortedByDepartureDate");
        Item item3 = new Item("show all guests sorted by name ", this, "showAllGuestsSortedByNameMenu");

        ViewModel viewModel = new ViewModel("GUEST MENU**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ShowAllGuestsView view = new ShowAllGuestsView(this.guestService.getAllGuests(), viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllGuestsSortedByNameMenu() {

        ArrayList<Guest> allGuests = this.guestService.getAllGuestsSortedByName();
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all guests sorted by departure date", this, "showAllGuestsSortedByDepartureDate");

        ViewModel viewModel = new ViewModel("GUEST MENU**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        ShowAllGuestsView view = new ShowAllGuestsView(allGuests, viewModel);
        view.showInformation();
        view.act();

    }

    public void showAllGuestsSortedByDepartureDate() {

        ArrayList<Guest> allGuests = this.guestService.getAllGuestsSortedByDateDeparture();
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all guests sorted by name date", this, "showAllGuestsSortedByNameMenu");
        ViewModel viewModel = new ViewModel("GUEST MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        ShowAllGuestsView view = new ShowAllGuestsView(allGuests, viewModel);
        view.showInformation();
        view.act();

    }

    public void showServiceMenu() {

        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all services", this, "showAllServicesMenu");
        Item item3 = new Item("show all services sorted by cost", this, "showAllServicesSortedByCost");

        ViewModel viewModel = new ViewModel("SERVICE MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        ServiceMenuView view = new ServiceMenuView(viewModel);
        view.act();

    }

    public void showAllServicesMenu() {
        ArrayList<Service> allServices = new ArrayList<Service>(this.serviceService.getAllHotelServices());
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all services sorted by cost", this, "showAllServicesSortedByCost");

        ViewModel viewModel = new ViewModel("SERVICE MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        ShowAllServicesView view = new ShowAllServicesView(allServices, viewModel);
        view.showInformation();
        view.act();
    }

    public void showAllServicesSortedByCost() {
        ArrayList<Service> allServices = new ArrayList<Service>(this.serviceService.getAllHotelServicesSortedByCost());
        Item item1 = new Item("Show Main Menu", this, "showMainMenu");
        Item item2 = new Item("show all services", this, "showAllServicesMenu");


        ViewModel viewModel = new ViewModel("SERVICE SORTED BY COST MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        ShowAllServicesView view = new ShowAllServicesView(allServices, viewModel);
        view.showInformation();
        view.act();
    }

    public MainService getMainService() {
        return mainService;
    }

}
