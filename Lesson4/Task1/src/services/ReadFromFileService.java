package services;


import Storage.RoomStorage;
import com.danco.training.TextFileWorker;
import entity.Room;

import java.util.ArrayList;
import java.util.List;

public class ReadFromFileService {

    private IRoomService roomService;

    public ReadFromFileService(IRoomService roomService){
        this.roomService=roomService;
    }

    public void readRooms(String path) {

        String[] allRooms = new TextFileWorker(path).readFromFile();

        for (String roomFromFile : allRooms) {
            int id = 0;
            String[] roomParametrs = roomFromFile.split("\\|");
            int roomNumber = Integer.parseInt(roomParametrs[0]);
            int roomCost = Integer.parseInt(roomParametrs[1]);
            int roomCapacity = Integer.parseInt(roomParametrs[2]);
            int roomStars = Integer.parseInt(roomParametrs[3]);

            Room room = new Room(id, roomNumber, roomCost, roomCapacity, roomStars);
            id++;

            this.roomService.addRoom(room);



        }
    }
}
