package com.queryService.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.queryService.socket.ClientSocket;
import com.queryService.queryEntity.QueryData;
import com.queryService.hotelEntity.Guest;
import com.queryService.hotelEntity.GuestServiceInfo;
import com.queryService.hotelEntity.Room;
import com.queryService.hotelEntity.Service;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class ClientService {
    private QueryData queryData = new QueryData();
    private ObjectMapper objectMapper = new ObjectMapper();
    private String hotelController = "com.testHotel.controller.IHotelController";
    private ClientSocket clientSocket = ClientSocket.getClientSocket();
    public static final Logger log = Logger.getLogger(ClientService.class);


    public void startSocket() {
        clientSocket.start();
    }

    public void closeSocket() {
        clientSocket.closeSocket();
    }

    public void addGuest(Integer roomNumber, Guest guest, Integer year, Integer month, Integer day) {

        this.queryData.getAllParamList().clear();
        this.queryData.setSomeClass(this.hotelController);
        this.queryData.setSomeMethod("addGuest");
        this.queryData.getAllParamList().add(roomNumber);
        this.queryData.getAllParamList().add(guest);
        this.queryData.getAllParamList().add(year);
        this.queryData.getAllParamList().add(month);
        this.queryData.getAllParamList().add(day);

        String serverAnswer = clientSocket.start(queryData);
    }

    public List<Room> getAllRooms() {

        this.queryData.getAllParamList().clear();
        this.queryData.setSomeClass(this.hotelController);
        queryData.setSomeMethod("getAllRooms");

        String serverAnswer = clientSocket.start(queryData);

        try {
            List<Room> allRooms = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return allRooms;
        } catch (IOException e) {
            log.error(e.toString());
        }
        return null;
    }


    public List<Guest> getAllGuests() {

        this.queryData.getAllParamList().clear();
        this.queryData.setSomeClass(this.hotelController);
        queryData.setSomeMethod("getAllGuests");
        String serverAnswer = clientSocket.start(queryData);
        try {
            List<Guest> allGuests = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Guest>>() {
            });
            return allGuests;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Room> getFreeRooms() {

        this.queryData.getAllParamList().clear();

        this.queryData.setSomeClass(this.hotelController);
        queryData.setSomeMethod("getFreeRooms");
        String serverAnswer = clientSocket.start(queryData);

        try {
            List<Room> allRooms = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return allRooms;
        } catch (IOException e) {
            log.error(e.toString());
        }
        return null;
    }

    public Room getRoomByNumber(Integer roomNumber) {

        this.queryData.getAllParamList().clear();
        this.queryData.setSomeClass(this.hotelController);
        queryData.setSomeMethod("getRoomByNumber");
        queryData.getAllParamList().add(roomNumber);

        String serverAnswer = clientSocket.start(queryData);
        try {
            Room room = this.objectMapper.readValue(serverAnswer, Room.class);
            return room;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;
    }

    public void addRoom(Room room) {
    }

    public Room clonerRoom(Room room) {
        return null;
    }

    public void exportRoom(String path) {
    }

    public void importRoom(String path) {
    }

    public List<Room> getRoomCapacitySorting() {
        return null;
    }

    public List<Room> getRoomCostSorting() {
        return null;
    }

    public List<Room> getRoomStarsSorting() {
        return null;
    }

    public List<Room> getArrayRoomCapacitySorting(List<Room> roomList) {
        return null;
    }

    public List<Room> getArrayRoomCostSorting(List<Room> roomList) {
        return null;
    }

    public List<Room> getArrayRoomStarsSorting(List<Room> roomList) {
        return null;
    }

    public List<Service> getAllHotelServices() {
        return null;
    }

    public void addHotelService(Service someService) {
    }

    public List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest) {
        return null;
    }

}
