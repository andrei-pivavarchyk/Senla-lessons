package ui.menuItem.RoomMenuItem;


import ui.controller.MenuController;
import ui.menuItem.MenuItem;

public class ShowAllRoomsItem extends MenuItem{

    public ShowAllRoomsItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }
    public void click(){
        this.menuController.showAllRoomsMenu();
    }


}
