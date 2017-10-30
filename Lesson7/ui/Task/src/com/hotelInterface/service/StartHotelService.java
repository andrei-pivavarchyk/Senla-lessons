package com.hotelInterface.service;

import com.serializingService.ISerializableService;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.service.IPrinterService;
import com.hotelInterface.entity.ProgramState;


public class StartHotelService {
    private static StartHotelService startHotelService;
    private DependencyService dependencyService;
    private IHotelController hotelController;
    private ISerializableService serializableService;

    private StartHotelService() {
        this.dependencyService = new DependencyService();
    }

    public static synchronized StartHotelService getStartHotelService() {
        if (startHotelService == null) {
            startHotelService = new StartHotelService();
        }
        return startHotelService;
    }

    public void startHotel() throws Exception {

        this.dependencyService.configureDependencyService();
        this.hotelController = this.dependencyService.getHotelController();

        this.serializableService = this.dependencyService.getSerializableService();
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
        if (this.serializableService != null) {
            return this.serializableService;
        } else {
            return this.dependencyService.getSerializableService();
        }
    }
}


