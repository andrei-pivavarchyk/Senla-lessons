package hotel.storeFactory;


import hotel.storage.IRoomStorage;
import hotel.storage.RoomStorage;

public class RoomStoreFactory extends AFactory<IRoomStorage>{
    @Override
    public IRoomStorage createStorage() {
        IRoomStorage roomStorage=new RoomStorage();
        return roomStorage;
    }
}
