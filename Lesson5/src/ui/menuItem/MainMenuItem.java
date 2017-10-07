package ui.menuItem;


import ui.Service.MenuService;
import ui.controller.MainController;

public class MainMenuItem extends  MenuItem {
    public MainMenuItem( String title, MainController mainController)
    {
        super( title, mainController);
    }



    public void click(){
        this.mainController.showMainMenu();
    }
}
