package com.hotelInterface.action;

import com.dependencyService.DependencyService;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelInterface.service.IPrinterService;
import com.hotelInterface.service.PrinterService;
import com.queryService.ClientSocket;
import com.queryService.QueryData;
import com.queryService.service.ClientService;
import com.testHotel.controller.IHotelController;
import com.hotelInterface.service.ConsoleService;


import org.apache.log4j.Logger;

import java.io.Serializable;


public class AAction implements Serializable{


    private IPrinterService printer = new PrinterService();
    private ConsoleService consoleService = ConsoleService.getConsoleService();
    private static Logger log=Logger.getLogger(AAction.class);
    private  ClientSocket clientSocket=new ClientSocket();
    private String hotelController="com.testHotel.controller.IHotelController";
    private QueryData queryData=new QueryData();
    private ObjectMapper objectMapper=new ObjectMapper();
    ClientService clientService=new ClientService();

    public ClientService getClientService() {
        return clientService;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public QueryData getQueryDataWitParameters() {
        return queryData;
    }
    public QueryData getQueryDataWithoutParameters() {
        this.queryData.getAllParamList().clear();
        this.queryData.getParameterClassList().clear();
        return this.queryData;
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

    public ClientSocket getClientSocket() {
        return clientSocket;
    }

    public String getHotelController() {
        return hotelController;
    }
}
