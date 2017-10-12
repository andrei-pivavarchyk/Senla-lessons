package entity;

import action.*;
import action.roomMenuActions.*;

public class Builder {

    private Menu rootMenu;

    public Menu buildMainMenu() {

        IAction action1 = new ActionShowGuestMenu();
        IAction action2 = new ActionShowRoomMenu();
        IAction action3 = new ActionShowServiceMenu();

        Menu menu = new Menu("Main menu");

        MenuItem menuItem1 = new MenuItem("Show Guest Menu", action1);
        MenuItem menuItem2 = new MenuItem("Show RoomMenu", action2, this.buildRoomMenu());
        MenuItem menuItem3 = new MenuItem("Show Service menu", action3);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);

        return menu;

    }

    public Menu buildRoomMenu() {
        IAction action1 = new ActionShowAllRooms();
        IAction action2 = new ActionShowFreeRooms();
        IAction action3 = new ActionPreviosMenu();

        Menu menu = new Menu("Room menu");

        MenuItem menuItem1 = new MenuItem("Show all Rooms", action1, this.buildAllRoomsSorted());
        MenuItem menuItem2 = new MenuItem("Show Free Rooms", action2, this.buildFreeRoomsSorted());
        MenuItem menuItem3 = new MenuItem("PreviousMenu", action3);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);

        return menu;

    }


    public Menu buildAllRoomsSorted() {

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


    public Menu buildFreeRoomsSorted() {
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


}
