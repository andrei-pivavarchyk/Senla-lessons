package ui.entity;

import ui.action.*;
import ui.action.guestMenuAction.ActionShowAllGuests;
import ui.action.roomMenuAction.*;
import ui.action.serviceMenuAction.ActionShowAllServices;
import ui.action.serviceMenuAction.ActionShowGuestServices;

public class Builder {


    public Menu buildMainMenu() {

        IAction action1 = new ActionShowGuestMenu();
        IAction action2 = new ActionShowRoomMenu();
        IAction action3 = new ActionShowServiceMenu();

        Menu menu = new Menu("ui.ui.Main menu");

        MenuItem menuItem1 = new MenuItem("Show Guest Menu", action1,this.buildGuestMenu());
        MenuItem menuItem2 = new MenuItem("Show RoomMenu", action2, this.buildRoomMenu());
        MenuItem menuItem3 = new MenuItem("Show Service menu", action3,this.buildServiceMenu());

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);

        return menu;

    }

    private Menu buildRoomMenu() {
        IAction action1=new ActionAddGuestToRoom();
        IAction action2 = new ActionShowAllRooms();
        IAction action3 = new ActionShowFreeRooms();
        IAction action4=new ActionCloneRoom();
        IAction action5 = new ActionPreviosMenu();

        Menu menu = new Menu("Room menu");

        MenuItem menuItem1 = new MenuItem("Add guest to room", action1);
        MenuItem menuItem2 = new MenuItem("Show All Rooms", action2, this.buildAllRoomsSorted());
        MenuItem menuItem3 = new MenuItem("Show Free Rooms", action3, this.buildFreeRoomsSorted());
        MenuItem menuItem4 = new MenuItem("Clone room", action4, this.buildFreeRoomsSorted());
        MenuItem menuItem5 = new MenuItem("PreviousMenu", action5);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);
        menu.addMenuItem(menuItem4);
        menu.addMenuItem(menuItem5);

        return menu;

    }


    private Menu buildAllRoomsSorted() {

        IAction action1 = new ActionShowAllRoomsSortedByCapacity();
        IAction action2 = new ActionShowAllRoomsSortedByCost();
        IAction action3 = new ActionShowAllRoomsSortedByStars();
        IAction action4 = new ActionPreviosMenu();

        Menu menu = new Menu("All room sorting menu");

        MenuItem menuItem1 = new MenuItem("Show all Rooms sorted by capacity", action1);
        MenuItem menuItem2 = new MenuItem("Show all Rooms sorted by cost", action2);
        MenuItem menuItem3 = new MenuItem("Show all Rooms sorted by stars", action3);
        MenuItem menuItem4 = new MenuItem("PreviousMenu", action4);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);
        menu.addMenuItem(menuItem4);

        return menu;
    }


    private Menu buildFreeRoomsSorted() {
        IAction action1 = new ActionShowFreeRoomsSortedByCapacity();
        IAction action2 = new ActionShowFreeRoomsSortedByStars();
        IAction action3 = new ActionShowFreeRoomsSortedByCost();
        IAction action4 = new ActionPreviosMenu();

        Menu menu = new Menu("Room menu");

        MenuItem menuItem1 = new MenuItem("Show all free room sorted by capacity", action1);
        MenuItem menuItem2 = new MenuItem("Show all free room sorted by stars", action2);
        MenuItem menuItem3 = new MenuItem("Show all free room sorted by cost", action3);
        MenuItem menuItem4 = new MenuItem("PreviousMenu", action4);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);
        menu.addMenuItem(menuItem4);

        return menu;

    }

    private Menu buildGuestMenu(){
        IAction action1 = new ActionShowAllGuests();
        IAction action2 = new ActionPreviosMenu();

        Menu menu = new Menu("Guest menu");

        MenuItem menuItem1 = new MenuItem("Show all guests", action1);
        MenuItem menuItem2 = new MenuItem("PreviousMenu", action2);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);

        return menu;
    }

    private Menu buildServiceMenu(){
        IAction action1 = new ActionShowAllServices();
        IAction action2 = new ActionShowGuestServices();
        IAction action3 = new ActionPreviosMenu();

        Menu menu = new Menu("Guest menu");

        MenuItem menuItem1 = new MenuItem("Show all hotel services", action1);
        MenuItem menuItem2 = new MenuItem("Show some guest services", action2);
        MenuItem menuItem3 = new MenuItem("PreviousMenu", action3);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);

        return menu;
    }
}
