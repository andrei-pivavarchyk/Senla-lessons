package com.hotelInterface.service;


import com.configurator.entity.ConfigProperty;
import com.configurator.entity.Configurator;
import com.propertyService.IPropertyService;
import com.propertyService.PropertyService;
import com.serializingService.ISerializableService;
import com.serializingService.SerializableService;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;
import com.testHotel.services.*;
import com.testHotel.storage.*;




public class DependencyService {


    private IGuestStorage guestStorage = new GuestStorage();
    private IRoomStorage roomStorage = new RoomStorage();
    private IServiceStorage serviceStorage = new ServiceStorage();
    private IGuestRoomInfoStorage guestRoomInfoStorage = new GuestRoomInfoStorage();
    private IGuestServiceStorage guestServiceStorage = new GuestServiceStorage();
    private ISerializableService serializableService=new SerializableService();
    private IPropertyService propertyService=new PropertyService();
    private IFileService fileService=new FileService();
    private IPrinterService printerService=new PrinterService();
    private Configurator configurator=new Configurator();

    private IGuestService guestService;
    private IRoomService roomService;
    private IServiceService serviceService;
    private IHotelController hotelController;


    //Creating all Services
    private IRoomService getRoomService() {
        if (this.roomService != null) {
            return this.roomService;
        } else {
            this.roomService = new RoomService();
            this.roomService.setGuestRoomInfoStorage(this.guestRoomInfoStorage);
            this.roomService.setGuestStorage(this.guestStorage);
            this.roomService.setRoomStorage(this.roomStorage);

            return this.roomService;
        }
    }

    private IGuestService getGuestService() {
        if (this.guestService != null) {
            return guestService;
        } else {
            this.guestService = new GuestService();
            this.guestService.setGuestRoomInfoStorage(this.guestRoomInfoStorage);
            return this.guestService;
        }
    }

    private IServiceService getServiceService() {
        if (this.serviceService != null) {
            return this.serviceService;
        } else {
            this.serviceService = new ServiceService();
            this.serviceService.setServiceStorage(this.serviceStorage);
            this.serviceService.setGuestServiceStorage(this.guestServiceStorage);
            return this.serviceService;
        }
    }

    public IFileService getFileService() {
        return this.fileService;
    }

    public IPrinterService getPrinterService() {
        return this.printerService;
    }

    public ISerializableService getSerializableService() {
        return serializableService;
    }

    public IPropertyService getPropertyService() {
        return propertyService;
    }

    public Configurator getConfigurator() {
        return configurator;
    }
    //End creating all services

    public IHotelController getHotelController() {
        if (this.hotelController != null) {
            return this.hotelController;
        } else {
            this.hotelController = new HotelController();
            this.hotelController.setFileService(this.getFileService());
            this.hotelController.setGuestService(this.getGuestService());
            this.hotelController.setPrinterService(this.getPrinterService());
            this.hotelController.setRoomService(this.getRoomService());
            this.hotelController.setServiceService(this.getServiceService());
            return this.hotelController;
        }
    }




}
