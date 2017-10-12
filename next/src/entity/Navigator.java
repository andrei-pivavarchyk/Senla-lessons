package entity;

import service.ConsoleService;

public class Navigator {
    Menu currentMenu;


    public void printMenu(Menu menu) {
        int i = 1;
        System.out.println(menu.getName());
        for (MenuItem menuItem : menu.getMenuItemList()) {
            System.out.println(new StringBuilder().append(i).append(" ").append(menuItem.getTitle()));
            i++;
        }
        int numberOfItems = menu.getMenuItemList().size();
        int number = ConsoleService.getConsoleService().getNumberForMenu(numberOfItems);
        this.currentMenu = menu;



        navigate(number, menu);
    }

    public void navigate(int number, Menu parentMenu) {

        ActionEnumResult result = this.currentMenu.getMenuItemList().get(number - 1).doAction();

      

        if (result.equals(ActionEnumResult.NEXT)) {
            Menu nextMenu = this.currentMenu.getMenuItemList().get(number - 1).getNextMenu();
            nextMenu.setRootMenu(parentMenu);

            printMenu(nextMenu);
        } else if (result.equals(ActionEnumResult.PREVIOUS)) {
            Menu rootMenu = this.currentMenu.getRootMenu();
            printMenu(rootMenu);

        } else if (result.equals(ActionEnumResult.TRUE)) {


            printMenu(this.currentMenu);

        }



    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

}
