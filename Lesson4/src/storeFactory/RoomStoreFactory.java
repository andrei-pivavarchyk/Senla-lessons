package storeFactory;


import storage.IBaseStorage;
import storage.IRoomStorage;
import storage.RoomStorage;

public class RoomStoreFactory extends AFactory<IRoomStorage>{
    @Override
    public IRoomStorage createStorage() {
        IRoomStorage roomStorage=new RoomStorage();
        return roomStorage;
    }
}
