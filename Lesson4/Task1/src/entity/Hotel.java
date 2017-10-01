package entity;

import services.*;

import java.util.Date;
import java.util.List;


public class Hotel {
    private String name;
    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;

    public Hotel(String name, IServiceService serviceService, IRoomService roomService, IGuestService guestService, PrinterService printerService) {

        this.name = name;
        this.serviceService=serviceService;
        this.roomService = roomService;
        this.guestSerice = guestService;
        this.printerService = printerService;


    }


    public void printAllRooms() {
        List<Room> roomList = this.roomService.getAllRooms();
        this.printerService.printRooms(roomList);
    }

    public void printRoomsSortingByCost() {
        List<Room> roomList = this.roomService.getAllRooms();
        this.printerService.printRooms(this.roomService.getRoomCostSorting(roomList));
    }

    public void printRoomsSortingByCapacity() {
        List<Room> roomList = this.roomService.getAllRooms();
        this.printerService.printRooms(this.roomService.getRoomCapacitySorting(roomList));
    }

    public void printRoomsSortingByStars() {
        List<Room> roomList = this.roomService.getAllRooms();
        this.printerService.printRooms(this.roomService.getRoomCostSorting(roomList));
    }

    public void printFreeRooms() {
        this.printerService.printRooms(this.roomService.getFreeRooms());
    }

    public void printFreeRoomsByCost() {

        List<Room> roomList = this.roomService.getFreeRooms();
        this.printerService.printRooms(this.roomService.getRoomCostSorting(roomList));
    }

    public void printFreeRoomsByCapacity() {
        List<Room> roomList = this.roomService.getFreeRooms();
        this.printerService.printRooms(this.roomService.getRoomCapacitySorting(roomList));
    }

    public void printFreeRoomsByStars() {
        List<Room> roomList = this.roomService.getFreeRooms();
        this.printerService.printRooms(this.roomService.getRoomStarsSorting(roomList));
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

    public void printFreeRoomsByDate(int year,int month, int day){
        printerService.printRooms(this.roomService.getFreeRoomsByDate(year,month,day));
    }
    public void printGuestPayAmount(Guest guest){
       int payAmount= this.guestSerice.getPayAmount(guest);
        System.out.println(new StringBuilder("Result pay:").append(payAmount).append("$"));
    }

    public void printLastThreeGuestsInRoom(int roomNumber){
        this.printerService.printGuestsWithDates(this.roomService.getThreeLastGuests(roomNumber));
    }

    public void addGuestService(Guest guest,Service service,int year,int month,int day){
        this.serviceService.addGuestService(guest,service,year,day,month);
    }

    public void printGuestServices(Guest guest){
        this.printerService.printGuestServices(this.serviceService.getAllGuestServicesInfo(guest));
    }

    public void printGuestServicesByDate(Guest guest){

        this.printerService.printGuestServices(this.serviceService.getAllGuestServicesInfoSortedByDate(guest));
    }

    public void printGuestServicesByCost(Guest guest){

        this.printerService.printGuestServices(this.serviceService.getAllGuestServicesInfoSortedByCost(guest));
    }

     public void readRoomsFromFile(String path){

         ReadFromFileService readFromFileService=new ReadFromFileService(roomService);
         readFromFileService.readRooms(path);

     }


}
