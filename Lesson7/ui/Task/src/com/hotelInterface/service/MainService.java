package com.hotelInterface.service;


import com.configurator.entity.Configurator;
import com.configurator.entity.IConfigurator;
import com.propertyService.IPropertyService;
import com.propertyService.PropertyService;
import com.serializingService.ISerializableService;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.service.IPrinterService;
import com.hotelInterface.entity.ProgramState;


public class MainService {

    private IHotelController hotelController;
    private ISerializableService serializableService;
    private static MainService mainService;
    private DependencyService dependencyService;
    private IConfigurator configurator;
    private IPropertyService propertyService;

    private MainService() {
        this.dependencyService = new DependencyService();
        this.configurator=new Configurator();
        this.propertyService=new PropertyService();
    }

    public static synchronized MainService getMainService() {
        if (mainService == null) {
            mainService = new MainService();
        }
        return mainService;
    }

    public void startHotel() throws Exception {

        this.configurator.configure(this.dependencyService, propertyService);
        this.serializableService = this.dependencyService.getSerializableService();
        this.configurator.configure(this.serializableService, propertyService);



        ProgramState programState = (ProgramState) serializableService.deSerializable();
        IPropertyService propertyService = this.dependencyService.getPropertyService();
       this.hotelController=this.dependencyService.getHotelController();
        this.configurator.configure(this.serializableService, propertyService);


        Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
        Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
        Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

        this.hotelController.addService(service1);
        this.hotelController.addService(service2);
        this.hotelController.addService(service3);


        if (programState == null) {
            this.hotelController.readRoomsFromFile();
        } else {
            this.hotelController.getRoomService().getAllRooms().addAll(programState.getRoomList());
        }
    }

    public IPrinterService getPrinterService() {
        return this.hotelController.getPrinterService();
    }

    public IHotelController getHotelController() {
        return this.hotelController;
    }

    public ISerializableService getSerializableService() {
        return serializableService;
    }
}


