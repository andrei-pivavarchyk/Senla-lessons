package com.hotelInterface.service;

import com.configurator.IConfigurator;
import com.dependencyService.DependencyService;
import com.serializingService.ISerializableService;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.service.IPrinterService;
import com.hotelInterface.entity.ProgramState;


public class StartHotelService {
    private IHotelController hotelController=(IHotelController) DependencyService.getDI().getInstance(IHotelController.class) ;
    private ISerializableService serializableService=(ISerializableService) DependencyService.getDI().getInstance(ISerializableService.class);
    private IConfigurator configurator=(IConfigurator) DependencyService.getDI().getInstance(IConfigurator.class);
    public void startHotel() throws Exception {


       this.configurator.configure( this.hotelController,DependencyService.getDI().getPropertyService());

        ProgramState programState = (ProgramState) this.serializableService.deSerializable();

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


