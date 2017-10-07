package ui.menuItem.GuestMenuItem;


import ui.Service.MenuService;
import ui.controller.MainController;
import ui.menuItem.MenuItem;

public class ShowAllGuestsSortedByDepartureDateItem extends MenuItem{
    public ShowAllGuestsSortedByDepartureDateItem( String title, MainController mainController) {
        super(title,mainController);
    }

    public void click(){
        this.mainController.showAllGuestsSortedByDepartureDate();
    }
}
