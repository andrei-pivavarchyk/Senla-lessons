package ui.controller;

import hotel.controller.HotelController;
import hotel.entity.*;
import hotel.storage.GuestRoomInfoStorage;
import hotel.storage.GuestStorage;
import ui.Main;
import ui.entity.Builder;
import ui.entity.Menu;
import ui.entity.Navigator;
import ui.entity.ProgramState;
import ui.service.ConsoleService;
import ui.service.MainService;
import ui.service.SerializableService;

import java.util.List;

public class MenuController {

    private Builder builder;
    private Navigator navigator;

    public MenuController() {
        this.builder = new Builder();

    }

    public void run() {
        //  MainService.getMainService().setHotelController(lastHotel);

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
                saveProgramState();
                running = false;
            }
        }

    }

    public void saveProgramState() {
        HotelController hotel = MainService.getMainService().getHotelController();
        ProgramState programState = new ProgramState();
        programState.setRoomList(hotel.getRoomService().getAllRooms());
        MainService.getMainService().getSerializableService().serializable(programState);
    }
}
