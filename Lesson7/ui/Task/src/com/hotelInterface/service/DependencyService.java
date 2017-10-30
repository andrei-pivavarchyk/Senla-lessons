package com.hotelInterface.service;


import com.configurator.entity.*;
import com.propertyService.IPropertyService;
import com.serializingService.ISerializableService;
import com.testHotel.controller.IHotelController;
import com.testHotel.service.*;
import com.testHotel.storage.*;
import org.apache.log4j.Logger;

import java.util.HashMap;

public class DependencyService {
    IFileService fileServicde = new FileService();
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IGUESTSTORAGE, type = PropertyType.STRING)
    private String guestStorage;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IROOMSTORAGE, type = PropertyType.STRING)
    private String roomStorage;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.ISERVICESTORAGE, type = PropertyType.STRING)
    private String serviceStorage;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IGUESTROOMINFOSTORAGE, type = PropertyType.STRING)
    private String guestRoomInfoStorage;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IGUESTSERVICESTORAGE, type = PropertyType.STRING)
    private String guestServiceStorage;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.ISERIALIZABLE, type = PropertyType.STRING)
    private String serializableService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IPROPERTYSERVICE, type = PropertyType.STRING)
    private String propertyService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IFILESERVICE, type = PropertyType.STRING)
    private String fileService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IPRINTERSERVICE, type = PropertyType.STRING)
    private String printerService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.ICONFIGURATOR, type = PropertyType.STRING)
    private String configurator;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IGUESTSERVICE, type = PropertyType.STRING)
    private String guestService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IROOMSERVICE, type = PropertyType.STRING)
    private String roomService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.ISERVICESERVICE, type = PropertyType.STRING)
    private String serviceService;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_DEPENDENCY, propertyName = PropertyName.IHOTELCONTROLLER, type = PropertyType.STRING)
    private String hotelController;
    private HashMap<String,Object> allStorages;
    public Logger log = Logger.getLogger(DependencyService.class);

    private IGuestStorage getGuestStorage() {
        try {
            Class storage = Class.forName(this.guestStorage);
            return (IGuestStorage) storage.newInstance();

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IRoomStorage getRoomStorage() {
        try {
            Class storage = Class.forName(this.roomStorage);
            return (IRoomStorage) storage.newInstance();

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IServiceStorage getServiceStorage() {
        try {
            Class storage = Class.forName(this.serviceStorage);
            return (IServiceStorage) storage.newInstance();

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IGuestRoomInfoStorage getGuestRoomInfoStorage() {
        try {
            Class storage = Class.forName(this.guestRoomInfoStorage);
            return (IGuestRoomInfoStorage) storage.newInstance();

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IGuestServiceStorage getGuestServiceStorage() {
        try {
            Class storage = Class.forName(this.guestServiceStorage);
            return (IGuestServiceStorage) storage.newInstance();

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }


    private IRoomService getRoomService() {
        try {
            Class roomServiceClass = Class.forName(this.roomService);
            IRoomService roomService = (IRoomService) roomServiceClass.newInstance();
            roomService.setGuestRoomInfoStorage(this.getGuestRoomInfoStorage());
            roomService.setGuestStorage(this.getGuestStorage());
            roomService.setRoomStorage(this.getRoomStorage());
            return roomService;

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IGuestService getGuestService() {
        try {
            Class guestServiceClass = Class.forName(this.guestService);
            IGuestService guestService = (IGuestService) guestServiceClass.newInstance();
            guestService.setGuestRoomInfoStorage(this.getGuestRoomInfoStorage());
            return guestService;

        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IServiceService getServiceService() {
        try {
            Class serviceServiceClass = Class.forName(this.serviceService);
            IServiceService guestService = (IServiceService) serviceServiceClass.newInstance();
            guestService.setGuestServiceStorage(this.getGuestServiceStorage());
            guestService.setServiceStorage(this.getServiceStorage());
            return guestService;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    private IFileService getFileService() {

        try {
            Class fileService = Class.forName(this.fileService);
            return (IFileService) fileService.newInstance();
        } catch (Exception e) {
            log.error(e);
            return null;
        }

    }


    private IPrinterService getPrinterService() {

        try {
            Class printerService = Class.forName(this.printerService);
            return (IPrinterService) printerService.newInstance();
        } catch (Exception e) {
            log.error(e);
            return null;
        }

    }


    public ISerializableService getSerializableService() {

        try {
            Class serializableService = Class.forName(this.serializableService);
            return (ISerializableService) serializableService.newInstance();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public IPropertyService getPropertyService() {
        try {
            Class propertyService = Class.forName(this.propertyService);
            return (IPropertyService) propertyService.newInstance();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }


    private IHotelController createHotelController() {
        try {
            Class hotelController = Class.forName(this.hotelController);
            return (IHotelController) hotelController.newInstance();
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }
    //End creating all services

    public IHotelController getHotelController() {

        IHotelController hotelControllerWithDependencies = this.createHotelController();
        hotelControllerWithDependencies.setFileService(this.getFileService());
        hotelControllerWithDependencies.setGuestService(this.getGuestService());
        hotelControllerWithDependencies.setPrinterService(this.getPrinterService());
        hotelControllerWithDependencies.setRoomService(this.getRoomService());
        hotelControllerWithDependencies.setServiceService(this.getServiceService());
        return hotelControllerWithDependencies;
    }
}



