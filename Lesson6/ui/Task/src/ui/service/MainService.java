package ui.service;


import hotel.controller.HotelController;
import hotel.entity.Service;
import hotel.entity.ServiceType;
import hotel.services.PrinterService;
import property.PropertyService;

import java.util.Properties;

public class MainService {

    private HotelController hotelController;
    private PrinterService printerService;
    private SerializableService serializableService;
    private static MainService mainService;

    private MainService() {
        PropertyService propertyService = new PropertyService();
        Properties properties = propertyService.getProperties("../resources/config.properties");

        this.hotelController = new HotelController(properties);
        this.serializableService = new SerializableService(properties);
        this.printerService = new PrinterService();
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

        this.hotelController.readRoomsFromFile();
        this.hotelController.addService(service1);
        this.hotelController.addService(service2);
        this.hotelController.addService(service3);

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
}

