package ui.Service;

import Storage.*;
import entity.Guest;
import entity.Service;
import services.*;
import ui.storeFactory.GuestStoreFactory;
import ui.storeFactory.RoomStoreFactory;
import ui.storeFactory.ServiceStoreFactory;

/**
 * Created by андрей on 09.10.2017.
 */
public class MainService {

    private IServiceService serviceService;
    private IRoomService roomService;
    private IGuestService guestSerice;
    private PrinterService printerService;



    public MainService() {

        IRoomStorage roomStorage = new RoomStoreFactory().createRoomStorage();
        IGuestStorage guestStorage = new GuestStoreFactory().createGuestStorage();
        IServiceStorage serviceStorage = new ServiceStoreFactory().createServiceStorage();
        IGuestServiceStorage guestServiceStorage = new GuestServiceStorage();
        IGuestRoomInfoStorage guestRoomInfoStorage = new GuestRoomInfoStorage();

        this.roomService = new RoomService(roomStorage, guestRoomInfoStorage, guestStorage);
        this.guestSerice = new GuestService(guestRoomInfoStorage);
        this.serviceService = new ServiceService(guestServiceStorage, serviceStorage);
        this.printerService = new PrinterService();


    }

    public void addGuest(int roomNumber, Guest guest, int year, int month, int day) {
        this.roomService.addGuest(roomNumber, guest, year, month + 1, day);
    }

    public void addService(Service service) {
        this.serviceService.addService(service);
    }

    public void readRoomsFromFile(String path) {

        ReadFromFileService readFromFileService = new ReadFromFileService(roomService);
        readFromFileService.readRooms(path);
    }


    public IRoomService getRoomService() {
        return roomService;
    }

    public IGuestService getGuestSerice() {
        return guestSerice;
    }

    public IServiceService getServiceService() {
        return serviceService;
    }

    public PrinterService getPrinterService() {
        return printerService;
    }
}
