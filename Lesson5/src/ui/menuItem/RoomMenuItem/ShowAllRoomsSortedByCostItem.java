package ui.menuItem.RoomMenuItem;

import ui.controller.MenuController;
import ui.menuItem.MainMenuItem;

/**
 * Created by андрей on 06.10.2017.
 */
public class ShowAllRoomsSortedByCostItem extends MainMenuItem{

    public ShowAllRoomsSortedByCostItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }
    public void click(){
        this.menuController.showAllRoomsSortedByCost();
    }

}
