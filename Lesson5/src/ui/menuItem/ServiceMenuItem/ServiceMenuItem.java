package ui.menuItem.ServiceMenuItem;


import ui.Service.MenuService;
import ui.controller.MainController;
import ui.menuItem.MenuItem;

public class ServiceMenuItem extends MenuItem{

    public ServiceMenuItem( String title, MainController mainController) {
        super( title, mainController);
    }
    public void click(){
        this.mainController.serviceMenu();
    }
}
