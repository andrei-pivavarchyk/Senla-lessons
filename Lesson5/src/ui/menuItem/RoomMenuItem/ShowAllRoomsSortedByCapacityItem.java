package ui.menuItem.RoomMenuItem;


import ui.controller.MenuController;
import ui.menuItem.MenuItem;

public class ShowAllRoomsSortedByCapacityItem extends MenuItem{
    public ShowAllRoomsSortedByCapacityItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }

    public void click() {
        this.menuController.showAllRoomsSortedByCapacity();
    }
}
