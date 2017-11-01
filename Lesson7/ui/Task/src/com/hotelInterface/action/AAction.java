package com.hotelInterface.action;

import com.dependencyService.DependencyService;
import com.hotelInterface.service.StartHotelService;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.IPrinterService;
import com.hotelInterface.service.ConsoleService;

import java.io.Serializable;

public class AAction implements Serializable{
    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private IPrinterService printer = this.hotelController.getPrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();

    public IHotelController getHotelController() {
        return hotelController;
    }

    public ConsoleService getConsoleService() {
        return consoleService;
    }

    public IPrinterService getPrinter() {
        return printer;
    }
}
