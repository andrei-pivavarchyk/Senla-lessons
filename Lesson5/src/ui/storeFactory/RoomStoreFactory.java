package ui.storeFactory;


import Storage.IRoomStorage;
import Storage.RoomStorage;

public class RoomStoreFactory extends ARoomStoreFactory {

    public IRoomStorage createRoomStorage(){

        IRoomStorage roomStorage=new RoomStorage();
        return roomStorage;

    }

}
