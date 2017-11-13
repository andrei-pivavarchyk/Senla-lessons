package com.hotelInterface.action;

import com.hotelInterface.service.IPrinterService;
import com.hotelInterface.service.PrinterService;
import com.queryService.service.ClientService;
import com.hotelInterface.service.ConsoleService;
import org.apache.log4j.Logger;

import java.io.Serializable;


public class AAction implements Serializable{

    private IPrinterService printer = new PrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();
    private static Logger log=Logger.getLogger(AAction.class);
    ClientService clientService= new ClientService();

    public ClientService getClientService() {
        return clientService;
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
