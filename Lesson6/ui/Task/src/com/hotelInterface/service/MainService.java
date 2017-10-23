package com.hotelInterface.service;


import com.testHotel.controller.HotelController;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.services.PrinterService;
import com.hotelInterface.entity.ProgramState;
import property.PropertyService;
import services.SerializableService;


import java.util.Properties;

public class MainService {

    private HotelController hotelController;
    private PrinterService printerService;
    private  SerializableService serializableService;
    private ProgramState programState;
    private static MainService mainService;


    private MainService() {

        PropertyService propertyService = new PropertyService();
        Properties properties = propertyService.readProperties("../resources/config.properties");

        this.hotelController = new HotelController(properties);
        this.serializableService = new SerializableService(properties);
        this.printerService = new PrinterService();
        this.programState = new ProgramState();
    }

    public static synchronized MainService getMainService() {
        if (mainService == null) {
            mainService = new MainService();
        }
        return mainService;
    }

    public void startHotel(String roomPath) {

        Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
        Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
        Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

        this.hotelController.addService(service1);
        this.hotelController.addService(service2);
        this.hotelController.addService(service3);

        SerializableService serializableService = MainService.getMainService().getSerializableService();
        ProgramState programState = (ProgramState)serializableService.deSerializable();

        if (programState == null) {
            this.hotelController.readRoomsFromFile();
        } else {
            this.hotelController.getRoomService().getAllRooms().addAll(programState.getRoomList());
        }
    }

    public PrinterService getPrinterService() {
        return printerService;
    }

    public HotelController getHotelController() {
        return this.hotelController;
    }

    public SerializableService getSerializableService() {
        return serializableService;
    }

    public ProgramState getProgramState() {
        return programState;
    }

    public void setProgramState(ProgramState programState) {
        this.programState = programState;
    }
}

