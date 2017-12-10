package com.testHotel.main;


import com.testHotel.controller.HotelController;
import com.testHotel.dao.ServiceGenericDao;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;

import java.util.List;

public class Main {
    public static void main(String[] args) {

       HotelController hotelController=new HotelController();
        hotelController.startHotel();

       // NetServerThread.start();

       Service service=new Service(8, ServiceType.EAT,"superSpa666",6);
        

          //  hotelController.addService(service);

        ServiceGenericDao serviceGenericDao=new ServiceGenericDao();
        serviceGenericDao.persist(service);

       List<Service> allServices= serviceGenericDao.getAll();
        hotelController.getPrinterService().printServices(allServices);

    }
}




