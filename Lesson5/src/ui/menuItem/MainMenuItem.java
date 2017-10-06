package ui.menuItem;


import ui.controller.MenuController;

public class MainMenuItem extends  MenuItem {
    public MainMenuItem(int id, String title, MenuController menuController) {
        super(id, title, menuController);
    }

    public void click(){
        this.menuController.showMainMenu();
    }
}
