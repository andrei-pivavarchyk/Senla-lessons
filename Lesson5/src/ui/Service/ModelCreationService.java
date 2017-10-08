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
        Item item3=new Item("show free rooms",mainController,"showFreeRoomsMenu");


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







}
