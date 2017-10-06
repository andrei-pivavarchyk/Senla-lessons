package ui.model;


import ui.menuItem.MenuItem;

import java.util.ArrayList;

public class ViewModel {
    public String title;
    public ArrayList<MenuItem> menuItems;


    public ViewModel(String title){
        this.title=title;
        menuItems=new ArrayList<MenuItem>();
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}
