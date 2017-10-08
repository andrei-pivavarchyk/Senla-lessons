package ui.menuItem.GuestMenuItem;


import ui.controller.MainController;
import ui.menuItem.MenuItem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GuestMenuItem extends MenuItem {


    public GuestMenuItem( String title, MainController mainController) {
        super( title, mainController);

    }

    public void click()  {
       this.mainController.showGuestMenu();
    }
}
