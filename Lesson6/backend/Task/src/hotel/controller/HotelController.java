package hotel.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import hotel.entity.Guest;
import hotel.entity.Room;
import hotel.entity.Service;
import hotel.storage.*;
import hotel.services.*;
import hotel.storeFactory.GuestStoreFactory;
import hotel.storeFactory.RoomStoreFactory;
import hotel.storeFactory.ServiceStoreFactory;
import property.EnumProperty;
import property.IPropertyService;
import property.PropertyService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class HotelController implements Serializable {

    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestService;
    private PrinterService printerService;
    private IPropertyService propertyService;
    private Properties properties;

    public HotelController(Properties properties) {

        IRoomStorage roomStorage = new RoomStoreFactory().createStorage();
        IGuestStorage guestStorage = new GuestStoreFactory().createStorage();
        IServiceStorage serviceStorage = new ServiceStoreFactory().createStorage();
        IGuestServiceStorage guestServiceStorage = new GuestServiceStorage();
        IGuestRoomInfoStorage guestRoomInfoStorage = new GuestRoomInfoStorage();
       this.propertyService = new PropertyService();

        Integer roomServiceParameter=propertyService.getIntegerProperty(EnumProperty.MAX_NUMBER_OF_LAST_ROOM_GUESTS,properties);

        this.properties = properties;
        this.roomService = new RoomService(roomStorage, guestRoomInfoStorage, guestStorage,roomServiceParameter);
        this.guestService = new GuestService(guestRoomInfoStorage);
        this.serviceService = new ServiceService(guestServiceStorage, serviceStorage);
        this.printerService = new PrinterService();

    }

    public void printAllRooms() {
        List<Room> roomList = this.roomService.getAllRooms();
        this.printerService.printRooms(roomList);
    }

    public void printRoomsSortingByCost() {

        this.printerService.printRooms(this.roomService.getRoomCostSorting());
    }

    public void printRoomsSortingByCapacity() {

        this.printerService.printRooms(this.roomService.getRoomCapacitySorting());
    }

    public void printRoomsSortingByStars() {

        this.printerService.printRooms(this.roomService.getRoomCostSorting());
    }

    public void printFreeRooms() {
        this.printerService.printRooms(this.roomService.getFreeRooms());
    }

    public void printFreeRoomsByCost() {

        this.printerService.printRooms(this.roomService.getRoomCostSorting());
    }

    public void printFreeRoomsByCapacity() {

        this.printerService.printRooms(this.roomService.getRoomCapacitySorting());
    }

    public void printFreeRoomsByStars() {

        this.printerService.printRooms(this.roomService.getRoomStarsSorting());
    }

    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        Boolean chooseRoomStatus = this.propertyService.getBooleanProperty(EnumProperty.CHOOSE_ROOM_STATUS,this.properties);

        if (chooseRoomStatus) {
            this.roomService.addGuest(roomNumber, guest, year, month + 1, day, true);
        } else {
            this.roomService.addGuest(roomNumber, guest, year, month + 1, day, false);
        }
    }

    public void printAllGuests() {
        this.printerService.printGuestsWithRoomNumbers(this.guestService.getCurrentGuestRoomInfo());

    }

    public void printGuestsSortedByName() {
        this.printerService.printGuests(this.guestService.getAllGuestsSortedByName());
    }

    public void printGuestsSortedByDepartureDate() {
        this.printerService.printGuests(this.guestService.getAllGuestsSortedByDateDeparture());
    }

    public void printFreeRoomsCount() {
        this.roomService.printFreeRoomsCount();
    }

    public void printAllGuestsCount() {
        this.guestService.printAllGuestsCount();
    }

    public void printFreeRoomsByDate(int year, int month, int day) {
        printerService.printRooms(this.roomService.getFreeRoomsByDate(year, month, day));
    }

    public void printGuestPayAmount(Guest guest) {
        int payAmount = this.guestService.getPayAmount(guest);
        System.out.println(new StringBuilder("Result pay:").append(payAmount).append("$"));
    }

    public void printLastThreeGuestsInRoom(int roomNumber) {
        this.printerService.printGuestsWithDates(this.roomService.getThreeLastGuests(roomNumber));
    }

    public void addGuestService(Guest guest, Service service, int year, int month, int day) {
        this.serviceService.addGuestService(guest, service, year, day, month);
    }

    public void printGuestServices(Guest guest) {
        this.printerService.printGuestServices(this.serviceService.getAllGuestServicesInfo(guest));
    }

    public void printGuestServicesByDate(Guest guest) {

        this.printerService.printGuestServices(this.serviceService.getAllGuestServicesInfoSortedByDate(guest));
    }

    public void printGuestServicesByCost(Guest guest) {

        this.printerService.printGuestServices(this.serviceService.getAllGuestServicesInfoSortedByCost(guest));
    }

    public void readRoomsFromFile() {
        String path = this.propertyService.getStringProperty(EnumProperty.ROOM_PATH_FILE,properties);
        ReadFromFileService readFromFileService = new ReadFromFileService();
        List<Room> roomList = readFromFileService.readRooms(path);
        this.roomService.getAllRooms().addAll(roomList);
    }

    public void setRoomCost(int roomNumber, int cost, String path) {
        this.roomService.setRoomCost(roomNumber, cost);
        ReadFromFileService readFromFileService = new ReadFromFileService();
        readFromFileService.writeToFileService(this.roomService.getAllRooms(), path);
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

    public void setGuestService(IGuestService guestService) {
        this.guestService = guestService;
    }

    public void setRoomService(IRoomService roomService) {
        this.roomService = roomService;
    }

    public void setServiceService(IServiceService serviceService) {
        this.serviceService = serviceService;
    }
}
