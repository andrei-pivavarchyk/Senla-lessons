package com.hotelInterface.action;

import com.dependencyService.DependencyService;

import com.testHotel.controller.IHotelController;
import com.testHotel.service.IPrinterService;
import com.hotelInterface.service.ConsoleService;
import org.apache.log4j.Logger;

import java.io.Serializable;


public class AAction implements Serializable{
    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private IPrinterService printer = this.hotelController.getPrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();
    private static Logger log=Logger.getLogger(AAction.class);

    public IHotelController getHotelController() {
        return hotelController;
    }

    public ConsoleService getConsoleService() {
        return consoleService;
    }

    public IPrinterService getPrinter() {
        return printer;
    }

    public static Logger getLog() {
        return log;
    }
}
