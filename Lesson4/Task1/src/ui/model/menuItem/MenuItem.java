package ui.model.menuItem;


import ui.View.IView;
import ui.View.guestView.MainGuestView;
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

    public void click(){

    }


}
