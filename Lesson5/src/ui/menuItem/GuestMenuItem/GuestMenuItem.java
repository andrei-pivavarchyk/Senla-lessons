package ui.menuItem.GuestMenuItem;


import ui.controller.MenuController;
import ui.menuItem.MenuItem;

public class GuestMenuItem extends MenuItem {


    public GuestMenuItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }

    public void click(){
        this.menuController.showGuestMenu();
    }
}
