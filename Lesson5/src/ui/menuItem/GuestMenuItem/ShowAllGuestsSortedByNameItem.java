package ui.menuItem.GuestMenuItem;

import ui.Service.MenuService;
import ui.controller.MainController;
import ui.menuItem.MenuItem;


public class ShowAllGuestsSortedByNameItem extends MenuItem {

    public ShowAllGuestsSortedByNameItem( String title, MainController mainController) {
        super( title, mainController);
    }
    public void click(){
        this.mainController.showAllGuestsSortedByName();
    }
}
