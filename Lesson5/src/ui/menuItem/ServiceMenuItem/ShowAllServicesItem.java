package ui.menuItem.ServiceMenuItem;


import entity.Guest;
import entity.Service;
import ui.controller.MenuController;
import ui.menuItem.MenuItem;
import ui.model.ViewModel;

import java.util.ArrayList;

public class ShowAllServicesItem extends MenuItem{


    public ShowAllServicesItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }
    public void click(){
        this.menuController.showAllServicesMenu();
    }

}
