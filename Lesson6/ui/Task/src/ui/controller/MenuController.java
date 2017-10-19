package ui.controller;

import ui.entity.Builder;
import ui.entity.Menu;
import ui.entity.Navigator;
import ui.service.ConsoleService;
import ui.service.MainService;
import ui.service.Serializable;

public class MenuController {

    Builder builder;
    Navigator navigator;

    public MenuController() {
        this.builder = new Builder();

    }

    public void run() {

        Menu mainMenu = this.builder.buildMainMenu();
        this.navigator = new Navigator();
        Boolean running = true;

       if(Serializable.deSerializable().equals(null)){
           navigator.printMenu(mainMenu);
       }
       else{
           Menu lastMenu=Serializable.deSerializable();
           navigator.printMenu(lastMenu);
       }


        while (running.equals(true)) {

            int numberOfItems = navigator.getCurrentMenu().getMenuItemList().size();
            int number = ConsoleService.getConsoleService().getNumberForMenu(numberOfItems);
            if (number != 666) {

                Menu menu = navigator.navigate(number);
                Serializable.serializableMenu(menu);
                navigator.printMenu(menu);
            } else {

                running = false;
            }
        }

    }
}
