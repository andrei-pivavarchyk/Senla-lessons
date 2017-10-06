package ui.menuItem;


import ui.controller.MenuController;

public abstract class MenuItem {
    public int id;
    public String title;
    public MenuController menuController;



    public MenuItem(int id, String title, MenuController menuController){
        this.id=id;
        this.title=title;
        this.menuController=menuController;

    }

    public abstract void click();


}
