package com.hotelInterface.service;


import com.serializingService.ISerializableService;
import com.serializingService.SerializableService;
import com.testHotel.controller.HotelController;
import com.testHotel.controller.IHotelController;
import com.testHotel.entity.Service;
import com.testHotel.entity.ServiceType;
import com.testHotel.services.IPrinterService;
import com.testHotel.services.PrinterService;
import com.hotelInterface.entity.ProgramState;
import property.PropertyService;



import java.util.Properties;

public class MainService {

    private IHotelController hotelController;
    private ISerializableService serializableService;
    private ProgramState programState;
    private static MainService mainService;
    private DependencyService dependencyService;



    private MainService() {

        this.dependencyService=new DependencyService();

    }

    public static synchronized MainService getMainService() {
        if (mainService == null) {
            mainService = new MainService();
        }
        return mainService;
    }

        public void startHotel(String roomPath) throws Exception {

        this.hotelController=this.dependencyService.getHotelController();
        this.dependencyService.getConfigurator().configure(this.hotelController,this.dependencyService.getPropertyService());
        this.hotelController.readRoomsFromFile();


            Service service1 = new Service(1, ServiceType.EAT, "Vodka", 10);
            Service service2 = new Service(1, ServiceType.EAT, "Pelmeni", 15);
            Service service3 = new Service(1, ServiceType.EAT, "Spa", 20);

            ISerializableService serializableService = MainService.getMainService().getDependencyService().getSerializableService();

            ProgramState programState = (ProgramState)serializableService.deSerializable("D:\\ser.out");

            if (programState == null) {
                this.hotelController.readRoomsFromFile();
            } else {
                this.hotelController.getRoomService().getAllRooms().addAll(programState.getRoomList());
            }

            this.hotelController.addService(service1);
            this.hotelController.addService(service2);
            this.hotelController.addService(service3);

        }

    public IPrinterService getPrinterService() {
        return this.dependencyService.getPrinterService();
    }

    public IHotelController getHotelController() {
        return this.hotelController;
    }

    public ISerializableService getSerializableService() {
        return this.dependencyService.getSerializableService();
    }

    public ProgramState getProgramState() {
        return programState;
    }

    public void setProgramState(ProgramState programState) {
        this.programState = programState;
    }

    public DependencyService getDependencyService() {
        return dependencyService;
    }
}


