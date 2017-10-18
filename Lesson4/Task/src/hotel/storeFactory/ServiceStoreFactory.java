package hotel.storeFactory;

import hotel.storage.IServiceStorage;
import hotel.storage.ServiceStorage;

public class ServiceStoreFactory extends AFactory<IServiceStorage> {
    @Override
    public IServiceStorage createStorage() {
        IServiceStorage serviceStorage=new ServiceStorage();
        return serviceStorage;
    }
}
