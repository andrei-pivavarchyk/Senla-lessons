package ui.menuItem.RoomMenuItem;


import ui.Service.MenuService;
import ui.controller.MainController;
import ui.menuItem.MenuItem;

public class ShowAllRoomsSortedByStarsItem extends MenuItem {

    public ShowAllRoomsSortedByStarsItem( String title, MainController mainController) {
        super( title, menuController);
    }

    public void click() {
        this.mainController.showAllRoomsSortedByStars();
    }
}
