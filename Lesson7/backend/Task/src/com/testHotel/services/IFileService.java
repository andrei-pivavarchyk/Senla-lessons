package com.testHotel.services;

import com.testHotel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public interface IFileService {
    ArrayList<Room> readRooms(String path)throws Exception;
   void writeRoomsToFile(List<Room> allRooms, String path) throws Exception;
}
