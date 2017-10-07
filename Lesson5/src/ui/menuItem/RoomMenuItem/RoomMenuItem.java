package ui.menuItem.RoomMenuItem;


import ui.Service.MenuService;
import ui.controller.MainController;
import ui.menuItem.MenuItem;

public class RoomMenuItem extends MenuItem{

    public RoomMenuItem( String title, MainController mainController) {
        super( title, mainController);
    }
    public void click(){
this.mainController.roomMenu();
    }
}
