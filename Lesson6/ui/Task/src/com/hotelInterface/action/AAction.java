package com.hotelInterface.action;

import com.testHotel.controller.HotelController;
import com.testHotel.services.PrinterService;
import com.hotelInterface.service.ConsoleService;
import com.hotelInterface.service.MainService;

import java.io.Serializable;

public class AAction implements Serializable{
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer = MainService.getMainService().getPrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();

    public HotelController getHotelController() {
        return hotelController;
    }

    public ConsoleService getConsoleService() {
        return consoleService;
    }

    public PrinterService getPrinter() {
        return printer;
    }
}
