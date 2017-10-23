package com.testHotel.storeFactory;

import com.testHotel.storage.IServiceStorage;
import com.testHotel.storage.ServiceStorage;

public class ServiceStoreFactory extends AFactory<IServiceStorage> {
    @Override
    public IServiceStorage createStorage() {
        IServiceStorage serviceStorage=new ServiceStorage();
        return serviceStorage;
    }
}
