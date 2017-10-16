package controller;

import entity.Builder;
import entity.Menu;
import entity.Navigator;
import service.ConsoleService;
import service.MainService;

public class MenuController {

    Builder builder;
    Navigator navigator;

    public MenuController() {
        this.builder = new Builder();

    }

    public void run() {

        Menu mainMenu = this.builder.buildMainMenu();
        this.navigator = new Navigator();
        navigator.printMenu(mainMenu);
        Boolean running = true;

        while (running.equals(true)) {

            int numberOfItems = navigator.getCurrentMenu().getMenuItemList().size();
            int number = ConsoleService.getConsoleService().getNumberForMenu(numberOfItems);
            if (number != 666) {

                Menu menu = navigator.navigate(number);
                navigator.printMenu(menu);
            } else {
                running = false;
            }
        }

    }
}
