package com.hotelInterface.controller;

import com.dependencyService.DependencyService;
import com.hotelInterface.service.StartHotelService;
import com.hotelInterface.entity.Builder;
import com.hotelInterface.entity.Menu;
import com.hotelInterface.entity.Navigator;
import com.hotelInterface.entity.ProgramState;
import com.hotelInterface.service.ConsoleService;
import com.serializingService.ISerializableService;
import com.testHotel.controller.IHotelController;

public class MenuController {

    private Builder builder;
    private Navigator navigator;
    private ISerializableService serializableService = (ISerializableService) DependencyService.getDI().getInstance(ISerializableService.class);

    public MenuController() {
        this.builder = new Builder();

    }

    public void run() {

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
        IHotelController hotel = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
        ProgramState programState = new ProgramState();
        programState.setRoomList(hotel.getRoomService().getAllRooms());
        programState.setServiceList(hotel.getServiceService().getAllHotelServices());


        this.serializableService.serializable(programState);
    }
}
