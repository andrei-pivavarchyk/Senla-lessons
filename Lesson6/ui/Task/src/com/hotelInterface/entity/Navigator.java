package com.hotelInterface.entity;

public class Navigator {
    Menu currentMenu;

    public void printMenu(Menu menu) {
        int i = 1;
        System.out.println(menu.getName());
        for (MenuItem menuItem : menu.getMenuItemList()) {
            System.out.println(new StringBuilder().append(i).append(" ").append(menuItem.getTitle()));
            i++;
        }
        this.currentMenu = menu;
    }

    public Menu navigate(int number) {

        ActionEnumResult result = this.currentMenu.getMenuItemList().get(number - 1).doAction();


        if (result.equals(ActionEnumResult.NEXT)) {
            Menu nextMenu = this.currentMenu.getMenuItemList().get(number - 1).getNextMenu();
            nextMenu.setRootMenu(this.currentMenu);
            return nextMenu;

        } else if (result.equals(ActionEnumResult.PREVIOUS)) {
            Menu rootMenu = this.currentMenu.getRootMenu();
            return rootMenu;

        } else if (result.equals(ActionEnumResult.TRUE)) {

            return this.currentMenu;

        }
        return null;
    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
