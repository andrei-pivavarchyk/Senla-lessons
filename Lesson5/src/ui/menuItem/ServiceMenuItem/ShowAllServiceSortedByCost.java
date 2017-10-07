package ui.menuItem.ServiceMenuItem;

import ui.Service.MenuService;
import ui.controller.MainController;
import ui.menuItem.MenuItem;

/**
 * Created by андрей on 06.10.2017.
 */
public class ShowAllServiceSortedByCost extends MenuItem{
    public ShowAllServiceSortedByCost( String title, MainController mainController) {
        super( title, mainController);
    }



    public void click(){
        this.mainController.showAllServicesMenuSortedByCost();
    }
}
