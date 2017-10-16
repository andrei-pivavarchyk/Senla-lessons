package action.serviceMenuAction;


import action.IAction;
import controller.HotelController;
import entity.ActionEnumResult;
import entity.Guest;
import entity.Service;
import service.MainService;
import services.PrinterService;

import java.util.ArrayList;
import java.util.List;

public class ActionShowAllServices implements IAction{
    private HotelController hotelController = MainService.getMainService().getHotelController();
    private PrinterService printer=MainService.getMainService().getPrinterService();

    public  ActionEnumResult execute(){
       List<Service> serviceList= hotelController.getServiceService().getAllHotelServices();
        printer.printServices(serviceList);
        return ActionEnumResult.TRUE;
    }
}
