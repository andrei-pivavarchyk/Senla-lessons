package storeFactory;

import storage.IBaseStorage;
import storage.IServiceStorage;
import storage.ServiceStorage;

public class ServiceStoreFactory extends AFactory<IServiceStorage> {
    @Override
    public IServiceStorage createStorage() {
        IServiceStorage serviceStorage=new ServiceStorage();
        return serviceStorage;
    }
}
