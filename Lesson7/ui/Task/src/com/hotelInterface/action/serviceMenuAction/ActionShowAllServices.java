package com.hotelInterface.action.serviceMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.testHotel.controller.HotelController;
import com.hotelInterface.entity.ActionEnumResult;
import com.testHotel.entity.Service;
import com.hotelInterface.service.MainService;
import com.testHotel.services.PrinterService;

import java.util.List;

public class ActionShowAllServices extends AAction implements IAction {
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer=MainService.getMainService().getPrinterService();

    public  ActionEnumResult execute(){
       List<Service> serviceList= hotelController.getServiceService().getAllHotelServices();
        printer.printServices(serviceList);
        return ActionEnumResult.TRUE;
    }
}