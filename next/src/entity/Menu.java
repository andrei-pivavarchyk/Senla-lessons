package entity;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String name;
    private ArrayList<MenuItem> menuItemList;
    private Menu rootMenu;



    public Menu(String name){
        this.name=name;
        this.menuItemList=new ArrayList<MenuItem>();
    }


    public void addMenuItem(MenuItem menuItem){
        this.menuItemList.add(menuItem);
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public String getName() {
        return name;
    }

    public void setRootMenu(Menu rootMenu) {
        this.rootMenu = rootMenu;
    }

    public Menu getRootMenu() {
        return rootMenu;
    }
}
