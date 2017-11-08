package com.testHotel.clientQuery;


import com.dependencyService.DependencyService;
import com.testHotel.service.IPrinterService;

public class ObjectSenderToClient implements IObjectSenderToClient {

    public IPrinterService getPrinterService(){
        IPrinterService printerService= (IPrinterService) DependencyService.getDI().getInstance(IPrinterService.class);
        return printerService;
    }




}
