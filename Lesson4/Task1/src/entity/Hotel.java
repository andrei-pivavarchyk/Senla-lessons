package entity;

import storage.*;
import services.*;

import java.util.List;


public class Hotel {

    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;

    public Hotel() {

        IRoomStorage roomStorage = new RoomStorage();
        IGuestStorage guestStorage = new GuestStorage();
        IServiceStorage serviceStorage = new ServiceStorage();
        IGuestServiceStorage guestServiceStorage = new GuestServiceStorage();
        IGuestRoomInfoStorage guestRoomInfoStorage = new GuestRoomInfoStorage();

        this.roomService = new RoomService(roomStorage, guestRoomInfoStorage, guestStorage);
        this.guestSerice = new GuestService(guestRoomInfoStorage);
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
        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void printAllGuests() {
     this.printerService.printGuestsWithRoomNumbers(this.guestSerice.getCurrentGuestRoomInfo());

    }

    public void printGuestsSortedByName() {
        this.printerService.printGuests(this.guestSerice.getAllGuestsSortedByName());
    }

    public void printGuestsSortedByDepartureDate() {
        this.printerService.printGuests(this.guestSerice.getAllGuestsSortedByDateDeparture());
    }

    public void printFreeRoomsCount() {
        this.roomService.printFreeRoomsCount();
    }

    public void printAllGuestsCount() {
        this.guestSerice.printAllGuestsCount();
    }

    public void printFreeRoomsByDate(int year, int month, int day) {
        printerService.printRooms(this.roomService.getFreeRoomsByDate(year, month, day));
    }

    public void printGuestPayAmount(Guest guest) {
        int payAmount = this.guestSerice.getPayAmount(guest);
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

    public void readRoomsFromFile(String path) {

        ReadFromFileService readFromFileService = new ReadFromFileService();
        readFromFileService.readRooms(path,this.roomService);

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
        return guestSerice;
    }

    public IRoomService getRoomService() {
        return roomService;
    }
}
