package com.hotelInterface.action.serviceMenuAction;

import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.queryService.hotelEntity.Service;
import com.queryService.hotelEntity.ServiceType;


import java.io.BufferedReader;

public class ActionAddHotelService extends AAction implements IAction {


    @Override
    public ActionEnumResult execute() {

        getPrinter().printString("Enter Service Type");

        ServiceType[] allServiceTypes = ServiceType.values();
        int i = 1;
        for (ServiceType serviceType : allServiceTypes) {
            StringBuilder stringBuilder = new StringBuilder().append(i).append(serviceType);
            getPrinter().printString(stringBuilder.toString());
            i++;
        }

        Integer typeNumber = getConsoleService().getNumberForMenu(allServiceTypes.length);
        try {
            ServiceType serviceType = allServiceTypes[typeNumber - 1];
            getPrinter().printString("Enter Service name");
            String serviceName = getConsoleService().getString();
            getPrinter().printString("Enter Service cost");
            Integer serviceCost = getConsoleService().getNumber();

            Integer serviceCount = getClientService().getAllHotelServices().size();
            Service service = new Service(serviceCount, serviceType, serviceName, serviceCost);
            getClientService().addHotelService(service);

            getPrinter().printString("service was added");
        } catch (ArrayIndexOutOfBoundsException e) {
            getLog().error(e.toString());
        }
        return ActionEnumResult.PREVIOUS;
    }
}
