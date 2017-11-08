package com.hotelInterface.action;

import com.dependencyService.DependencyService;

import com.hotelInterface.querySenderService.ClientController;
import com.hotelInterface.querySenderService.ClientSocket;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.IPrinterService;
import com.hotelInterface.service.ConsoleService;
import com.testHotel.service.PrinterService;
import org.apache.log4j.Logger;

import java.io.Serializable;


public class AAction implements Serializable{
    ClientController clientController=new ClientController();
    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private IPrinterService printer = new PrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();
    private static Logger log=Logger.getLogger(AAction.class);
    ClientSocket clientSocket=new ClientSocket();

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

    public ClientController getClientController() {
        return clientController;
    }

    public ClientSocket getClientSocket() {
        return clientSocket;
    }
}
