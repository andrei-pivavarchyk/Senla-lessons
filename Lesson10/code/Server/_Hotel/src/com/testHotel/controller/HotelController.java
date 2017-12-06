package com.testHotel.controller;

import com.configurator.*;

import com.dependencyService.DependencyService;
import com.serializingService.ISerializableService;
import com.testHotel.entity.Guest;
import com.testHotel.entity.ProgramState;
import com.testHotel.entity.Room;
import com.testHotel.entity.Service;
import com.testHotel.service.*;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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

    //for mysql
    private Connection con;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.URL)
    private String url;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.USER)
    private String user;
    @ConfigProperty(configPath = PropertyFilePath.CONFIG_HOTEL_PROPERTIES, propertyName = PropertyName.PASSWORD)
    private String password;

    public void startHotel() {

        this.configurator.configure(this);
        this.configurator.configure(this.serializableService);

        ProgramState programState = (ProgramState) this.serializableService.deSerializable();

        if (programState == null) {
            try {
                this.readRoomsFromFile();
            } catch (Exception e) {
                log.error(e.toString());
            }

        } else {
            this.getRoomService().getAllRooms().addAll(programState.getRoomList());
            this.getServiceService().getAllHotelServices().addAll(programState.getServiceList());
        }
        this.setConnection();
    }


    public void endHotel() {

        ProgramState programState = new ProgramState();
        programState.setRoomList(this.getRoomService().getAllRooms());
        programState.setServiceList(this.getServiceService().getAllHotelServices());
        this.serializableService.serializable(programState);
        if (this.con != null) {
            try {
                this.con.close();
            } catch (SQLException e) {
                log.error(e.toString());
            }
        }

    }


    private Connection getConnection() {

        String query = "select count(*) from books";
        if (con != null) {
            return con;
        } else {
            try {

                con = DriverManager.getConnection(url, user, password);
                return con;

            } catch (SQLException e) {
                log.error(e.toString());
                return null;
            }
        }
    }


    public void setConnection() {

        this.serviceService.setConnection(this.getConnection());
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
        try {
            Room cloneRoom = this.roomService.cloneRoom(room);
            return cloneRoom;
        } catch (CloneNotSupportedException e) {
            this.printerService.printString("Cannot cloe object");
        }

        return null;
    }

    public List<Room> getAllRooms() {
        return this.roomService.getAllRooms();
    }

    public List<Guest> getAllGuests() {
        return this.guestService.getAllGuests();

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

    public Room getRoomByNumber(Integer number) {
        return this.roomService.getRoomByNumber(number);
    }

    public  List<Service> getAllServices(){
      return  this.serviceService.getAllHotelServices();
    }

}
