package com.testHotel.service;


import com.configurator.IConfigurator;
import com.dependencyService.DependencyService;
import com.serializingService.ISerializableService;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.ProgramState;
import org.apache.log4j.Logger;

public class StartHotelService {

    private IHotelController hotelController = (IHotelController) DependencyService.getDI().getInstance(IHotelController.class);
    private ISerializableService serializableService = (ISerializableService) DependencyService.getDI().getInstance(ISerializableService.class);
    private IConfigurator configurator = (IConfigurator) DependencyService.getDI().getInstance(IConfigurator.class);
    private static Logger log = Logger.getLogger(DependencyService.class);


public void startHotel(){

    this.configurator.configure(this.hotelController);
    this.configurator.configure(this.serializableService);

    ProgramState programState = (ProgramState) this.serializableService.deSerializable();


    if (programState == null) {
        try {
            this.hotelController.readRoomsFromFile();
        } catch (Exception e) {
            log.error(e.toString());
        }

    } else {
        this.hotelController.getRoomService().getAllRooms().addAll(programState.getRoomList());
        this.hotelController.getServiceService().getAllHotelServices().addAll(programState.getServiceList());
    }

}



}
