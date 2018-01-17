package com.testHotel.controller;

import com.configurator.*;


import com.dao.TypeSorting;
import com.dependencyService.DependencyService;
import com.entity.*;
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
    public Logger log = Logger.getLogger(GuestService.class);

    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.ROOM_PATH_FILE)
    private String roomFilePath;

    public HotelController() {
        this.configurator.configure(this);
    }

    public void startHotel() {
        this.configurator.configure(this);
    }


    /**
     * guest
     */
    public void addGuest(Guest guest) {
        this.guestService.addGuest(guest);
    }
    public List<Guest> getAllGuests(TypeSorting sorting) {
        return this.guestService.getAllGuests(sorting);
    }
    public Integer getPayAmount(Guest guest) {
        return this.guestService.getPayAmount(guest);
    }
    public List<GuestRoomInfo> getCurrentGuestRoomInfo() {
        return this.guestService.getCurrentGuestRoomInfo();
    }
    public Long getAllGuestsCount() {
        return this.guestService.getAllGuestsCount();
    }
    public Guest getGuestById(Integer id) {
        return this.guestService.getGuestById(id);
    }
    public void updateGuest(Guest guest) {
        this.guestService.updateGuest(guest);
    }
    public void removeGuest(Integer id) {
        Guest guest = this.guestService.getGuestById(id);
        guestService.removeGuest(id);
    }
    /**
     * room
     */
    public Room getRoomByNumber(Integer number) {
        return this.roomService.getRoomByNumber(number);
    }
    public Room getRoomById(Integer id) {
        return this.roomService.getRoomById(id);
    }
    public void addRoom(Room room) {
        this.getRoomService().addRoom(room);
    }
    public void updateRoom(Room entity){
        this.roomService.updateEntity(entity);
    }
    public void deleteRoom(Integer id) {
        this.roomService.deleteEntity(id);
    }

    public List<Room> getAllRooms(TypeSorting sorting, RoomStatus status) {
        return this.roomService.getAllRooms(sorting,status);
    }

    /**
     * service
     */

    public List<Service> getAllHotelServices(TypeSorting sorting) {
        return this.serviceService.getAllHotelServices(sorting);
    }
    public Service getServiceById(Integer id) {
        return this.serviceService.getServiceById(id);
    }
    public void addHotelService(Service service) {
        this.serviceService.addHotelService(service);
    }
    public void updateService(Service service){
        this.serviceService.updateService(service);
    }
    public void deleteService(Integer id) {
        this.serviceService.deleteService(id);
    }

    /**
     * guestservice
     */
    public List<GuestServiceInfo> getAllGuestServicesInfo(TypeSorting sorting) {
        List<GuestServiceInfo> allGuestServicesInfo = this.serviceService.getAllGuestServiceInfo(sorting);
        return allGuestServicesInfo;
    }

    public void addGuestServiceInfo(GuestServiceInfo guestRoomInfo) {
        this.serviceService.addGuestServiceInfo(guestRoomInfo);
    }

    public List<GuestServiceInfo> getGuestServiceByGuest(Integer id,TypeSorting sorting) {
        Guest guest=this.guestService.getGuestById(id);
        return this.serviceService.getAllGuestServicesInfoByGuest(guest,sorting);
    }

    public void removeGuestServiceInfoByGuest(Integer id) {
        this.serviceService.removeGuestServiceByGuest(id);
    }

    public void updateGuestServiceInfo(GuestServiceInfo guestServiceInfo) {
        this.serviceService.updateGuestService(guestServiceInfo);
    }


    /**
     * guestRoomInfo
     */
    public void addGuestToRoom(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day) {
        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public IPrinterService getPrinterService() {
        return printerService;
    }

    public void readRoomsFromFile() {
        List<Room> roomList = null;
        try {
            roomList = this.fileService.readRooms(this.roomFilePath);
            this.roomService.getAllRooms(TypeSorting.NO_SORTING,RoomStatus.FREE).addAll(roomList);
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public void setRoomCost(int roomNumber, int cost) {
        this.roomService.setRoomCost(roomNumber, cost);
    }

    public String getRoomFilePath() {
        return roomFilePath;
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


    public void importRoom(String path) throws Exception {
        List<Room> importRoomList = this.fileService.readRooms(path);
        this.roomService.importRooms(importRoomList);
    }

    public void exportRoom(String path) throws Exception {
        List<Room> roomList = this.roomService.getAllRooms(TypeSorting.NO_SORTING,RoomStatus.FREE);
        this.fileService.exportRoomsToFile(roomList, path);
    }

    public void endHotel() {
    }
}
