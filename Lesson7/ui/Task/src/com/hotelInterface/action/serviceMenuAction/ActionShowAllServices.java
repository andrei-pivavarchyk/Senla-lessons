package com.hotelInterface.action.serviceMenuAction;


import com.hotelInterface.action.AAction;
import com.hotelInterface.action.IAction;
import com.testHotel.controller.HotelController;
import com.hotelInterface.entity.ActionEnumResult;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Service;
import com.hotelInterface.service.MainService;
import com.testHotel.service.IPrinterService;
import com.testHotel.service.PrinterService;

import java.util.List;

public class ActionShowAllServices extends AAction implements IAction {
    private IHotelController hotelController = MainService.getMainService().getHotelController();
    private IPrinterService printer=MainService.getMainService().getPrinterService();

    public  ActionEnumResult execute(){
       List<Service> serviceList= hotelController.getServiceService().getAllHotelServices();
        printer.printServices(serviceList);
        return ActionEnumResult.TRUE;
    }
}
