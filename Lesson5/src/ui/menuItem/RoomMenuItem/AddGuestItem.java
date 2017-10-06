package ui.menuItem.RoomMenuItem;

import ui.controller.MenuController;
import ui.menuItem.MenuItem;


public class AddGuestItem extends MenuItem{
    public AddGuestItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }
    public void click(){
        this.menuController.roomMenu();
    }
}
