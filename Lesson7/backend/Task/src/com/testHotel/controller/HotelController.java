package com.testHotel.controller;

import com.configurator.*;

import com.dependencyService.DependencyService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.Room;
import com.testHotel.entity.Service;
import com.testHotel.service.*;

import java.util.List;


public class HotelController implements IHotelController {

    private IServiceService serviceService= (IServiceService) DependencyService.getDI().getInstance(IServiceService.class);

    @Configurable
    private IRoomService roomService=(IRoomService)DependencyService.getDI().getInstance(IRoomService.class);
    private IGuestService guestService=(IGuestService)DependencyService.getDI().getInstance(IGuestService.class);
    private IPrinterService printerService=(IPrinterService)DependencyService.getDI().getInstance(IPrinterService.class);
    private IFileService fileService=(IFileService)DependencyService.getDI().getInstance(IFileService.class);

    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.ROOM_PATH_FILE, type = PropertyType.STRING)
    private String roomFilePath;



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

    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {

        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void addGuestService(Guest guest, Service service, int year, int month, int day) {
        this.serviceService.addGuestService(guest, service, year, day, month);
    }

    public void readRoomsFromFile() throws Exception {
        List<Room> roomList = this.fileService.readRooms(this.roomFilePath);
        this.roomService.getAllRooms().addAll(roomList);
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
        try {
            Room cloneRoom = this.roomService.cloneRoom(room);
            return cloneRoom;
        } catch (CloneNotSupportedException e) {
            this.printerService.printString("Cannot cloe object");
        }

        return null;
    }

    public void addRoom(Room room) {
        this.getRoomService().getAllRooms().add(room);
    }

    public void importRoom(String path) throws Exception {
        List<Room> importRoomList = this.fileService.readRooms(path);
        this.roomService.glueTwoArrays(importRoomList);
    }

    public void exportRoom(String path) throws Exception {
        List<Room> roomList = this.roomService.getAllRooms();
        this.fileService.exportRoomsToFile(roomList, path);
    }

}
