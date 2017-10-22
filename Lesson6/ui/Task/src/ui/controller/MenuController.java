package ui.controller;

import ui.Main;
import ui.entity.Builder;
import ui.entity.Menu;
import ui.entity.Navigator;
import ui.service.ConsoleService;
import ui.service.MainService;
import ui.service.SerializableService;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = new Builder();

    }

    public void run() {
        SerializableService serializableService = MainService.getMainService().getSerializableService();

        Menu mainMenu = this.builder.buildMainMenu();
        this.navigator = new Navigator();
        Boolean running = true;

        navigator.printMenu(mainMenu);


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
