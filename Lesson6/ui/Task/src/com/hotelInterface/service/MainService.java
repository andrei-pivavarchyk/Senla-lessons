package com.hotelInterface.service;


import com.propertyService.IPropertyService;
import com.propertyService.PropService;
import com.serializingService.SerializableService;
import com.testHotel.controller.HotelController;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.services.PrinterService;
import com.hotelInterface.entity.ProgramState;


import com.propertyService.PropertyService;

import java.io.IOException;

public class MainService {

    private HotelController hotelController;
    private PrinterService printerService;
    private SerializableService serializableService;
    private ProgramState programState;
    private static MainService mainService;
    private IPropertyService propertyService;

    private MainService() {
        this.serializableService = new SerializableService();
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

        try {
            PropService propService = new PropService();
            propService.setProperties("../resources/config.properties");

            this.propertyService = propService;
        } catch (IOException e) {
            printerService.printString(e.toString());
        }

        this.hotelController = new HotelController(this.propertyService);

        Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
        Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
        Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

        this.hotelController.addService(service1);
        this.hotelController.addService(service2);
        this.hotelController.addService(service3);

        ProgramState programState = (ProgramState) this.serializableService.deSerializable("D:\\ser.out");

        if (programState == null) {
            this.hotelController.readRoomsFromFile();
        } else {
            this.hotelController.getRoomService().getAllRooms().addAll(programState.getRoomList());
        }
    }

    public void saveProgramState() {
        ProgramState programState = new ProgramState();
        programState.setRoomList(this.hotelController.getRoomService().getAllRooms());
        this.serializableService.serializable(programState, "D:\\Rooms.txt");
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

