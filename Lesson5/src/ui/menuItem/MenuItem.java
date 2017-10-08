package ui.menuItem;



import ui.controller.MainController;

import java.lang.reflect.InvocationTargetException;

public abstract class MenuItem {
    public String title;
    public MainController mainController;


    public MenuItem( String title, MainController mainController){
        this.title=title;
        this.mainController=mainController;

    }


    public abstract void click();


}
