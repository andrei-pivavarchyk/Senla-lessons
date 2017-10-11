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
        this.builder =new Builder();

    }

    public void run() {
            Menu menu= this.builder.buildMainMenu();
             this.navigator = new Navigator(menu);
             navigator.printMenu();
    }
}
