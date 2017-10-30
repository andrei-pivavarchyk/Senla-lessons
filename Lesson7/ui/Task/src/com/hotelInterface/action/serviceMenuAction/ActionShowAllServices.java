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
    private IHotelController hotelController = StartHotelService.getStartHotelService().getHotelController();
    private IPrinterService printer= StartHotelService.getStartHotelService().getPrinterService();

    public  ActionEnumResult execute(){
       List<Service> serviceList= hotelController.getServiceService().getAllHotelServices();
        printer.printServices(serviceList);
        return ActionEnumResult.TRUE;
    }
}
