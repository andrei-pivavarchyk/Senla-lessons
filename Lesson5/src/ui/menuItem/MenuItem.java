package ui.menuItem;


import ui.Service.MenuService;
import ui.controller.MainController;

public abstract class MenuItem {
    public String title;
    public MainController mainController;


    public MenuItem( String title, MainController mainController){
        this.title=title;
        this.mainController=mainController;

    }


    public abstract void click();


}
