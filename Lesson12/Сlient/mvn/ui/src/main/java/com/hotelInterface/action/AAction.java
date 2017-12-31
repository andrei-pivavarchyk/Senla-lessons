package com.hotelInterface.action;

import com.DependencyService.DependencyService;
import com.hotelInterface.service.IPrinterService;
import com.hotelInterface.service.PrinterService;
import com.queryService.service.ClientService;
import com.hotelInterface.service.ConsoleService;
import com.queryService.service.IClientService;
import org.apache.log4j.Logger;

import java.io.Serializable;


public class AAction implements Serializable{

    private IPrinterService printer = new PrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();
    private static Logger log=Logger.getLogger(AAction.class);
    IClientService clientService=(IClientService) DependencyService.getDI().getInstance(IClientService.class);

    public IClientService getClientService() {
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
