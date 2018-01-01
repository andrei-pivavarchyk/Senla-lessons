package main.java.com.testHotel.main;



import com.testHotel.controller.HotelController;
import com.testHotel.entity.*;

public class Main {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.startHotel();
        System.out.println(55555);
        // NetServerThread.start();

        Service service=new Service(85,ServiceType.EAT,"vod5ka",858);

        hotelController.addService(service);

    }
}




