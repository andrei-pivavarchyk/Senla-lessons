package storeFactory;


import storage.IBaseStorage;
import storage.IRoomStorage;
import storage.RoomStorage;

public class RoomStoreFactory extends ARoomStoreFactory{
    @Override
    public IRoomStorage createRoomStorage() {
        IRoomStorage roomStorage=new RoomStorage();
        return roomStorage;
    }
}
