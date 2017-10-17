package service;


import com.danco.training.TextFileWorker;


import controller.HotelController;
import entity.Service;
import entity.ServiceType;
import services.PrinterService;

public class MainService {

    private HotelController hotelController;
    private PrinterService printerService;

    private static MainService mainService;

    private MainService() {
        this.hotelController = new HotelController();
        this.printerService = new PrinterService();

    }

    public static synchronized MainService getMainService() {
        if (mainService == null) {
            mainService = new MainService();
        }
        return mainService;
    }


    public void startHotel(String roomPath) {



        Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
        Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
        Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

        this.hotelController.readRoomsFromFile(roomPath);
        this.hotelController.addService(service1);
        this.hotelController.addService(service2);
        this.hotelController.addService(service3);


    }

    public PrinterService getPrinterService() {
        return printerService;
    }

    public HotelController getHotelController() {
        return this.hotelController;

    }
}

