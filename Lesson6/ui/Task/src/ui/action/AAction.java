package ui.action;

import hotel.controller.HotelController;
import hotel.services.PrinterService;
import ui.service.ConsoleService;
import ui.service.MainService;

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
