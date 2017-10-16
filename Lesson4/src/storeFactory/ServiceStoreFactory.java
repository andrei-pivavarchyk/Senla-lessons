package storeFactory;

import storage.IBaseStorage;
import storage.IServiceStorage;
import storage.ServiceStorage;

public class ServiceStoreFactory extends AServiceStoreFactory {
    @Override
    public IServiceStorage createServiceStorage() {
        IServiceStorage serviceStorage=new ServiceStorage();
        return serviceStorage;
    }
}
