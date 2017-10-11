package service;


import controller.HotelController;
import controller.IHotelController;

public class MainService {


    public static HotelController getHotelController() {
       return HotelController.getHotelController();

    }
}
