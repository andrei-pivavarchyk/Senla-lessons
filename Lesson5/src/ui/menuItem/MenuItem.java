package ui.menuItem;



import ui.controller.MainController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class MenuItem {
    private String title;
    private MainController mainController;
    private Method method;


    public MenuItem( String title, MainController mainController,Method method){
        this.title=title;
        this.mainController=mainController;
        this.method=method;

    }


    public abstract void click();

    public String getTitle() {
        return title;
    }

    public MainController getMainController() {
        return mainController;
    }
}
