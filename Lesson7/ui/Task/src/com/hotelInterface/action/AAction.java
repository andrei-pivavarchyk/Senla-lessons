package com.hotelInterface.action;

import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.IPrinterService;
import com.testHotel.service.PrinterService;
import com.hotelInterface.service.ConsoleService;
import com.hotelInterface.service.MainService;

import java.io.Serializable;

public class AAction implements Serializable{
    private IHotelController hotelController = MainService.getMainService().getHotelController();
    private IPrinterService printer = MainService.getMainService().getPrinterService();
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
