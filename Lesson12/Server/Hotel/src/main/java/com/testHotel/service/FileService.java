package com.testHotel.service;


import com.entity.Room;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class FileService implements IFileService {
    public Logger log = Logger.getLogger(GuestService.class);

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

    public void exportRoomsToFile(List<Room> allRooms, String path) throws IllegalArgumentException{

        String[] roomArray = new String[allRooms.size()];
        int i = 0;
        for (Room room : allRooms) {

            StringBuilder roomStringBuilder = new StringBuilder().append(room.getId()).append("|").append(room.getNumber()).append("|").append(room.getCost()).append("|").
                    append(room.getCapacity()).append("|").append(room.getStars());

            String string = roomStringBuilder.toString();
            roomArray[i] = string;
            i++;
        }
        new TextFileWorker(path).writeToFile(roomArray);

    }

    public void writeRoomToFile(Room room,String path) throws FileNotFoundException {

        StringBuilder roomStringBuilder = new StringBuilder().append(room.getId()).append("|").append(room.getNumber()).append("|").append(room.getCost()).append("|").
                append(room.getCapacity()).append("|").append(room.getStars());

        String string = roomStringBuilder.toString();
        String[] roomArray=new String[1];
        roomArray[0]=string;

        new TextFileWorker(path).writeToFile(roomArray);

    }






}
