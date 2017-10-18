package ui.action.serviceMenuAction;


import ui.action.AAction;
import ui.action.IAction;
import hotel.controller.HotelController;
import ui.entity.ActionEnumResult;
import hotel.entity.Service;
import ui.service.MainService;
import hotel.services.PrinterService;

import java.util.List;

public class ActionShowAllServices extends AAction implements IAction{
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer=MainService.getMainService().getPrinterService();

    public  ActionEnumResult execute(){
       List<Service> serviceList= hotelController.getServiceService().getAllHotelServices();
        printer.printServices(serviceList);
        return ActionEnumResult.TRUE;
    }
}
