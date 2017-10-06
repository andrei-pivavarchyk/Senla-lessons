package ui.menuItem.ServiceMenuItem;

import ui.controller.MenuController;
import ui.menuItem.MenuItem;

/**
 * Created by андрей on 06.10.2017.
 */
public class ShowAllServicesSortedByType extends MenuItem{
    public ShowAllServicesSortedByType(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }
    public void click(){
        this.menuController.showAllGuestsMenu();
    }
}
