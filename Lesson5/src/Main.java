import controller.HotelController;

import controller.MenuController;
import entity.Service;
import entity.ServiceType;
import service.MainService;

public class Main {

    public static void main(String[] args) {


        //creating services
        Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
        Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
        Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

        HotelController bestHotel =  MainService.getHotelController();
        bestHotel.readRoomsFromFile("D:\\Rooms.txt");
        bestHotel.addService(service1);
        bestHotel.addService(service2);
        bestHotel.addService(service3);


        MenuController menuController=new MenuController();
        menuController.run();

    }

    }
