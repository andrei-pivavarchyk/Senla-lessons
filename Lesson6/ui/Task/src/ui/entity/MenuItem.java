package ui.entity;

import ui.action.IAction;

import java.io.Serializable;

public class MenuItem implements Serializable {
    String title;
    IAction action;
    Menu nextMenu;
    public MenuItem(String title, IAction action) {
        this.title = title;
        this.action = action;
    }

    public MenuItem(String title, IAction action, Menu nextMenu)
    {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }
    public ActionEnumResult doAction() {

        ActionEnumResult result = this.action.execute();
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setNextMenu(Menu nextMenu) {
        this.nextMenu = nextMenu;
    }

    public Menu getNextMenu() {
        return nextMenu;
    }


}
