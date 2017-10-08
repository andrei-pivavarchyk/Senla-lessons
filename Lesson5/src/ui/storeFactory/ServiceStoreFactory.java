package ui.storeFactory;


import Storage.IRoomStorage;
import Storage.IServiceStorage;
import Storage.RoomStorage;
import Storage.ServiceStorage;

public class ServiceStoreFactory extends AServiceStoreFactory{


    public IServiceStorage createServiceStorage(){

        IServiceStorage serviceStorage=new ServiceStorage();
        return serviceStorage;

    }
}
