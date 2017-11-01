package com.hotelInterface.action.serviceMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.hotelInterface.service.StartHotelService;
import com.hotelInterface.entity.ActionEnumResult;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Service;
import com.testHotel.service.IPrinterService;

import java.util.List;

public class ActionShowAllServices extends AAction implements IAction {


    public  ActionEnumResult execute(){
       List<Service> serviceList= getHotelController().getServiceService().getAllHotelServices();
        getPrinter().printServices(serviceList);
        return ActionEnumResult.TRUE;
    }
}
