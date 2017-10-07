package ui.model;


import ui.menuItem.MenuItem;

import java.util.ArrayList;


public class ViewModel {

    private String title;
    private ArrayList<MenuItem> menuItems;
    private static volatile ViewModel instance;



    public static ViewModel getModel(String title) {
        ViewModel localInstance = instance;
        if (localInstance == null) {
            synchronized (ViewModel.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ViewModel();
                    localInstance.setTitle(title);

                }
            }
            return localInstance;
        }

        else{
            instance.setTitle(title);

        }

        return instance;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addItem(MenuItem item){
        this.menuItems.add(item);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }
}