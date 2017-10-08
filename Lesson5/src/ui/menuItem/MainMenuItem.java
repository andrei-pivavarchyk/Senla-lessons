package ui.menuItem;



import ui.controller.MainController;

import java.lang.reflect.InvocationTargetException;

public class MainMenuItem extends  MenuItem {
    public MainMenuItem( String title, MainController mainController)
    {
        super( title, mainController);
    }



    public void click() {
        this.mainController.showMainMenu();
    }
}
