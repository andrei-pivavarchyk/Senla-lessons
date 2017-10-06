package ui.menuItem.ServiceMenuItem;

import ui.controller.MenuController;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

/**
 * Created by андрей on 06.10.2017.
 */
public class ShowAllServiceSortedByCost extends MenuItem{
    public ShowAllServiceSortedByCost(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }



    public void click(){
        this.menuController.showAllServicesMenuSortedByCost();
    }
}
