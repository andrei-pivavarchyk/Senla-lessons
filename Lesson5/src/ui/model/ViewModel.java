package ui.model;


import ui.menuItem.Item;
import ui.menuItem.MenuItem;

import java.util.ArrayList;


public class ViewModel {

    private String title;
    private ArrayList<Item> menuItems=new ArrayList<Item>();


public ViewModel(String title){
    this.title=title;
}



    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addItem(Item item){
        this.menuItems.add(item);
    }

    public ArrayList<Item> getMenuItems() {
        return menuItems;
    }
}