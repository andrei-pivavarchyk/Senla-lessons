package ui.menuItem.GuestMenuItem;


import ui.controller.MenuController;
import ui.menuItem.MenuItem;

public class ShowAllGuestsSortedByDepartureDateItem extends MenuItem{
    public ShowAllGuestsSortedByDepartureDateItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }

    public void click(){
        this.menuController.showAllGuestsSortedByDepartureDate();
    }
}
