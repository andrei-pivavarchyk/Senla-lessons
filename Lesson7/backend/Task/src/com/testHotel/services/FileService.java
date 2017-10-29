package com.testHotel.services;


import com.danco.training.TextFileWorker;
import com.testHotel.entity.Room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FileService implements IFileService {


    public ArrayList<Room> readRooms(String path)throws IllegalArgumentException {

        String[] allRooms = new TextFileWorker(path).readFromFile();
        ArrayList<Room> roomList = new ArrayList<Room>();

        for (String roomFromFile : allRooms) {
            String[] roomParametrs = roomFromFile.split("\\|");
            int roomId = Integer.parseInt(roomParametrs[0]);
            int roomNumber = Integer.parseInt(roomParametrs[1]);
            int roomCost = Integer.parseInt(roomParametrs[2]);
            int roomCapacity = Integer.parseInt(roomParametrs[3]);
            int roomStars = Integer.parseInt(roomParametrs[4]);

            Room room = new Room(roomId, roomNumber, roomCost, roomCapacity, roomStars);

            roomList.add(room);
        }
        return roomList;
    }

    public void writeRoomsToFile(List<Room> allRooms, String path) throws IllegalArgumentException{

        String[] roomArray = new String[allRooms.size()];
        int i = 0;
        for (Room room : allRooms) {

            StringBuilder roomStringBuilder = new StringBuilder().append(room.getId()).append("|").append(room.getNumber()).append("|").append(room.getCost()).append("|").
                    append(room.getCapacity()).append("|").append(room.getStars());

            String string = roomStringBuilder.toString();
            roomArray[i] = string;
            System.out.println(allRooms.get(i));

            i++;
        }
        new TextFileWorker(path).writeToFile(roomArray);


    }
}
