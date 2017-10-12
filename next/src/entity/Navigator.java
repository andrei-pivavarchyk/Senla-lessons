package entity;

import action.ActionEnumResult;
import service.ConsoleService;

public class Navigator {
    Menu currentMenu;

    public Navigator(Menu currentMenu) {

        this.currentMenu = currentMenu;
    }


    public void printMenu(){
        int i = 1;
        System.out.println(currentMenu.getName());
        for (MenuItem menuItem : this.currentMenu.getMenuItemList()) {
            System.out.println(new StringBuilder().append(i).append(" ").append(menuItem.getTitle()));
            i++;
        }
        int numberOfItems = currentMenu.getMenuItemList().size();
        int number = ConsoleService.getConsoleService().getNumberForMenu(numberOfItems);
        navigate(number);
    }


    public void navigate(int number) {

            ActionEnumResult result = this.currentMenu.getMenuItemList().get(number - 1).doAction();

            if (result.equals(ActionEnumResult.NEXT)) {
                Menu nextMenu = this.currentMenu.getMenuItemList().get(number - 1).getNextMenu();
                nextMenu.setRootMenu(this.currentMenu);
                this.currentMenu = nextMenu;
                printMenu();

            }

           else if (result.equals(ActionEnumResult.PREVIOUS)) {
                Menu parentMenu = this.currentMenu.getRootMenu();

                this.currentMenu = parentMenu;
                printMenu();

            }

          else if(result.equals(ActionEnumResult.TRUE)){


                printMenu();

            }

    }

    public Menu getCurrentMenu() {
        return currentMenu;
    }

}
