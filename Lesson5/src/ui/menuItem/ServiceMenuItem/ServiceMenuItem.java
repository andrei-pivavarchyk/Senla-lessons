package ui.menuItem.ServiceMenuItem;


import ui.controller.MenuController;
import ui.menuItem.MenuItem;

public class ServiceMenuItem extends MenuItem{

    public ServiceMenuItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }
    public void click(){
        this.menuController.serviceMenu();
    }
}
