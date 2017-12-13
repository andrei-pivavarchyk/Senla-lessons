package com.testHotel.service;

import com.testHotel.entity.Room;

import java.util.ArrayList;
import java.util.List;

public interface IFileService {
    ArrayList<Room> readRooms(String path)throws Exception;
    void exportRoomsToFile(List<Room> allRooms, String path) throws IllegalArgumentException;
}