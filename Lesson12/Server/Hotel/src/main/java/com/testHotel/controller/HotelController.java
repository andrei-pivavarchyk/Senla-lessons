package com.testHotel.controller;

import com.configurator.*;

import com.dependencyService.DependencyService;
import com.entity.Guest;
import com.entity.Room;
import com.entity.Service;
import com.serializingService.ISerializableService;
import com.testHotel.service.*;
import org.apache.log4j.Logger;

import java.util.List;


public class HotelController implements IHotelController {

    private IServiceService serviceService = (IServiceService) DependencyService.getDI().getInstance(IServiceService.class);

    @Configurable
    private IRoomService roomService = (IRoomService) DependencyService.getDI().getInstance(IRoomService.class);
    private IGuestService guestService = (IGuestService) DependencyService.getDI().getInstance(IGuestService.class);
    private IPrinterService printerService = (IPrinterService) DependencyService.getDI().getInstance(IPrinterService.class);
    private IFileService fileService = (IFileService) DependencyService.getDI().getInstance(IFileService.class);
    private IConfigurator configurator = (IConfigurator) DependencyService.getDI().getInstance(IConfigurator.class);
    private ISerializableService serializableService = (ISerializableService) DependencyService.getDI().getInstance(ISerializableService.class);
    public Logger log = Logger.getLogger(GuestService.class);

    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.ROOM_PATH_FILE)
    private String roomFilePath;

    public void startHotel() {

        this.configurator.configure(this);
        this.configurator.configure(this.serializableService);

    }


    public void endHotel() {
    }


    public List<Room> getFreeRooms() {
        return this.roomService.getFreeRooms();
    }

    public void setFileService(IFileService fileService) {
        this.fileService = fileService;
    }

    public void setPrinterService(IPrinterService printerService) {
        this.printerService = printerService;
    }

    public void setGuestService(IGuestService guestService) {
        this.guestService = guestService;
    }

    public void setRoomService(IRoomService roomService) {
        this.roomService = roomService;
    }

    public void setServiceService(IServiceService serviceService) {
        this.serviceService = serviceService;
    }

    public IPrinterService getPrinterService() {
        return printerService;
    }

    public void addGuest(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day) {

        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void addGuestService(Guest guest, Service service, Integer year, Integer month, Integer day) {
        this.serviceService.addGuestService(guest, service, year, day, month);
    }

    public void readRoomsFromFile() {
        List<Room> roomList = null;
        try {
            roomList = this.fileService.readRooms(this.roomFilePath);
            this.roomService.getAllRooms().addAll(roomList);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void setRoomCost(int roomNumber, int cost, String path) {
        this.roomService.setRoomCost(roomNumber, cost);
        FileService readFromFileService = new FileService();
        readFromFileService.exportRoomsToFile(this.roomService.getAllRooms(), path);
    }

    public String getRoomFilePath() {
        return roomFilePath;
    }

    public void addService(Service service) {
        this.serviceService.addService(service);
    }

    public IGuestService getGuestSerice() {
        return guestService;
    }

    public IRoomService getRoomService() {
        return roomService;
    }

    public IServiceService getServiceService() {
        return serviceService;
    }

    public Room cloneRoom(Room room) {
      /*  try {
            Room cloneRoom = this.roomService.cloneRoom(room);
            return cloneRoom;
        } catch (CloneNotSupportedException e) {
            this.printerService.printString("Cannot cloe object");
        }
*/
        return null;
    }

    public List<Room> getAllRooms() {
        return this.roomService.getAllRooms();
    }

    public List<Guest> getAllGuests() {
        return this.guestService.getAllGuests();

    }
    public void printAllGuestsCount(){
        Integer allGuestsCount=this.guestService.getAllGuestsCount();
        this.printerService.printString(allGuestsCount.toString());
    }

    public void addRoom(Room room) {
        this.getRoomService().addRoom(room);
    }

    public void importRoom(String path) throws Exception {
        List<Room> importRoomList = this.fileService.readRooms(path);
        this.roomService.importRooms(importRoomList);
    }

    public void exportRoom(String path) throws Exception {
        List<Room> roomList = this.roomService.getAllRooms();
        this.fileService.exportRoomsToFile(roomList, path);
    }

    public Room getRoomByNumber(Integer number) {
        return this.roomService.getRoomByNumber(number);
    }

    public List<Service> getAllServices() {
        return this.serviceService.getAllHotelServices();
    }

}
