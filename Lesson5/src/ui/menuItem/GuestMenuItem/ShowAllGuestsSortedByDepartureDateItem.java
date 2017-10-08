package ui.menuItem.GuestMenuItem;



import ui.controller.MainController;
import ui.menuItem.MenuItem;

public class ShowAllGuestsSortedByDepartureDateItem extends MenuItem{
    public ShowAllGuestsSortedByDepartureDateItem( String title, MainController mainController) {
        super(title,mainController);
    }

    public void click(){
        this.mainController.showAllGuestsSortedByDepartureDateMenu();
    }
}
