package ui.Service;

import ui.controller.MainController;

import ui.menuItem.Item;

import ui.model.ViewModel;

import java.lang.reflect.Method;

public class ModelCreationService {
    private MainController mainController;

    public ModelCreationService(MainController mainController){
        this.mainController=mainController;
    }

    public ViewModel createModelForMainMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show guest menu",mainController,"showGuestMenu");
        Item item3=new Item("Show room menu", mainController,"showRoomMenu");
        Item item4=new Item("Show service menu",mainController,"showServiceMenu");

        ViewModel viewModel=new ViewModel("MAIN MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);

        return viewModel;
    }

    public ViewModel createModelForRoomMenu(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms",mainController,"showAllRoomsMenu");
        Item item3=new Item("show free rooms",mainController,"showAllFreeRoomsMenu");


        ViewModel viewModel=new ViewModel("ROOM MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);


        return viewModel;
    }

    public ViewModel createModelForShowAllRoomsMenu(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms sorted by Cost", mainController,"showAllRoomsSortedByCostMenu");
        Item item3=new Item("show all rooms sorted by Stars",mainController,"showAllRoomsSortedByCapacityMenu");
        Item item4=new Item("show all rooms sorted by capacity",mainController,"showAllRoomsSortedByStarsMenu");

        ViewModel viewModel=new ViewModel("ALL ROOMS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);

        return viewModel;
    }

    public ViewModel createModelForShowAllRoomsSortedByCostMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms sorted by Stars",mainController,"showAllRoomsSortedByStarsMenu");
        Item item3=new Item("show all rooms sorted by capacity",mainController,"showRoomsSortedByCapacityMenu");

        ViewModel viewModel=new ViewModel("ALL ROOMS SORTED BY COST MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);

        return viewModel;
}
    public ViewModel createModelForShowAllRoomsSortedByStarsMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms sorted by Cost", mainController,"showRoomsSortedByCostMenu");
        Item item3=new Item("show all rooms sorted by capacity",mainController,"showAllRoomsSortedByCapacityMenu");

        ViewModel viewModel=new ViewModel("ALL ROOMS SORTED BY STARS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);

        return viewModel;
    }
    public ViewModel createModelForShowAllRoomsSortedByCapacityMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms sorted by Stars",mainController,"showRoomsSortedByStars");
        Item item3=new Item("show all rooms sorted by Cost", mainController,"showRoomsSortedByCost");

        ViewModel viewModel=new ViewModel("ALL ROOMS SORTED BY CAPACITY MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);

        return viewModel;
    }



    public ViewModel createModelForShowAllFreeRoomsMenu(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all free rooms sorted by Cost", mainController,"showAllFreeRoomsSortedByCostMenu");
        Item item3=new Item("show all free rooms sorted by Stars",mainController,"showAllFreeRoomsSortedByCapacityMenu");
        Item item4=new Item("show all free rooms sorted by capacity",mainController,"showAllFreeRoomsSortedByStarsMenu");

        ViewModel viewModel=new ViewModel("ALL FREE ROOMS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        viewModel.addItem(item4);

        return viewModel;
    }

    public ViewModel createModelForshowAllFreeRoomsSortedByCostMenu(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all free rooms sorted by Stars",mainController,"showAllFreeRoomsSortedByCapacityMenu");
        Item item3=new Item("show all free rooms sorted by capacity",mainController,"showAllFreeRoomsSortedByStarsMenu");

        ViewModel viewModel=new ViewModel("ALL FREE ROOMS  SORTED BY COST MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);

        return viewModel;
    }


    public ViewModel createModelForShowAllFreeRoomsSortedByStarsMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms sorted by Cost", mainController,"showAllFreeRoomsSortedByCostMenu");
        Item item3=new Item("show all rooms sorted by capacity",mainController,"showAllFreeRoomsSortedByCapacityMenu");

        ViewModel viewModel=new ViewModel("ALL FREE ROOMS SORTED BY STARS MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);

        return viewModel;
    }
    public ViewModel createModelForShowAllFreeRoomsSortedByCapacityMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all rooms sorted by Stars",mainController,"showAllFreeRoomsSortedByStarsMenu");
        Item item3=new Item("show all rooms sorted by Cost", mainController,"showAllFreeRoomsSortedByCostMenu");

        ViewModel viewModel=new ViewModel("ALL ROOMS SORTED BY CAPACITY MENU_**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);

        return viewModel;
    }

    public ViewModel createModelForShowGuestMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all guests",mainController,"showAllGuestsMenu");
        ViewModel view=new ViewModel("GUEST MENU**************_-_");
        view.addItem(item1);
        view.addItem(item2);
        return view;
    }


    public ViewModel createModelForShowAllGuestsMenu(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");

        Item item2=new Item("show all guests sorted by departure date",mainController,"showAllGuestsSortedByDepartureDate");
        Item item3=new Item("show all guests sorted by name ",mainController,"showAllGuestsSortedByNameMenu");

        ViewModel view=new ViewModel("GUEST MENU**************_-_");

        view.addItem(item1);
        view.addItem(item2);
        view.addItem(item3);

        return view;
    }



    public ViewModel createModelForShowAllGuestsSortedByName(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all guests sorted by departure date",mainController,"showAllGuestsSortedByDepartureDate");

        ViewModel viewModel=new ViewModel("GUEST MENU**************_-_");

        viewModel.addItem(item1);
        viewModel.addItem(item2);
        return viewModel;
    }

    public ViewModel createModelForShowAllGuestsSortedByDepartureDate(){

        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all guests sorted by name date",mainController,"showAllGuestsSortedByNameMenu");
        ViewModel viewModel=new ViewModel("GUEST MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        return viewModel;
    }




    public ViewModel createModelForShowServicesMenu(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all services",mainController,"showAllServicesMenu");
        Item item3=new Item("show all services sorted by cost",mainController,"showAllServicesSortedByCost");

        ViewModel viewModel=new ViewModel("SERVICE MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        viewModel.addItem(item3);
        return viewModel;
    }



    public ViewModel createModelForShowAllServicesMenu(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all services sorted by cost",mainController,"showAllServicesSortedByCost");

        ViewModel viewModel=new ViewModel("SERVICE MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        return viewModel;
    }

    public ViewModel createModelForShowAllServicesSortedByCost(){
        Item item1=new Item("Show Main Menu", mainController,"showMainMenu");
        Item item2=new Item("show all services",mainController,"showAllServicesMenu");


        ViewModel viewModel=new ViewModel("SERVICE SORTED BY COST MENU**************_-_");
        viewModel.addItem(item1);
        viewModel.addItem(item2);
        return viewModel;
    }





}
