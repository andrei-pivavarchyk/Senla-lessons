package entity;

import action.*;
import action.roomMenuActions.ActionShowAllRooms;
import action.roomMenuActions.ActionShowFreeRooms;

public class Builder {

    private Menu rootMenu;
    public Menu buildMainMenu() {

        IAction action1 = new ActionShowGuestMenu();
        IAction action2 = new ActionShowRoomMenu();
        IAction action3 = new ActionShowServiceMenu();

        Menu menu = new Menu("Main menu");

        MenuItem menuItem1 = new MenuItem("Show Guest Menu", action1);
        MenuItem menuItem2 = new MenuItem("Show RoomMenu", action2,this.buildRoomMenu());
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

        MenuItem menuItem1 = new MenuItem("Show all Rooms", action1);
        MenuItem menuItem2 = new MenuItem("Show Free Rooms", action2);
        MenuItem menuItem3 = new MenuItem("PreviousMenu", action3);

        menu.addMenuItem(menuItem1);
        menu.addMenuItem(menuItem2);
        menu.addMenuItem(menuItem3);

        return menu;

    }










    public Menu getRootMenu() {
        return rootMenu;
    }
}
