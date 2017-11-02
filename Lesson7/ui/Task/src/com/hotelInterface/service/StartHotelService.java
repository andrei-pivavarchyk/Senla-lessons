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


       this.configurator.configure(this.hotelController);
this.configurator.configure(this.serializableService);
        ProgramState programState = (ProgramState) this.serializableService.deSerializable();


        if (programState == null) {
            this.hotelController.readRoomsFromFile();
        } else {
            this.hotelController.getRoomService().getAllRooms().addAll(programState.getRoomList());
            this.hotelController.getServiceService().getAllHotelServices().addAll(programState.getServiceList());

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


