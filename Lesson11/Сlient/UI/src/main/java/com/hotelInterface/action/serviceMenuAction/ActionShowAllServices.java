package com.hotelInterface.action.serviceMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.entity.ActionEnumResult;
import com.entity.Service;

import java.util.List;

public class ActionShowAllServices extends AAction implements IAction {


    public  ActionEnumResult execute(){

       List<Service> serviceList= getClientService().getAllHotelServices();
        getPrinter().printServices(serviceList);

        return ActionEnumResult.TRUE;
    }
}
