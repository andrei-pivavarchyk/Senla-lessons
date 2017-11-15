package com.queryService.service;

import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Room;
import com.entity.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.queryService.socket.ClientSocket;
import com.queryService.queryEntity.QueryData;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.List;

public class ClientService implements IClientService{
    private QueryData queryData = new QueryData();
    private ObjectMapper objectMapper = new ObjectMapper();
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
        this.queryData.setSomeMethod("addGuest");
        this.queryData.getAllParamList().add(roomNumber);
        this.queryData.getAllParamList().add(guest);
        this.queryData.getAllParamList().add(year);
        this.queryData.getAllParamList().add(month);
        this.queryData.getAllParamList().add(day);

        String serverAnswer = clientSocket.send(queryData);
    }

    public List<Room> getAllRooms() {

        this.queryData.getAllParamList().clear();
        queryData.setSomeMethod("getAllRooms");

        String serverAnswer = clientSocket.send(queryData);

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
        queryData.setSomeMethod("getAllGuests");
        String serverAnswer = clientSocket.send(queryData);
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
        queryData.setSomeMethod("getFreeRooms");
        String serverAnswer = clientSocket.send(queryData);

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
        queryData.setSomeMethod("getRoomByNumber");
        queryData.getAllParamList().add(roomNumber);

        String serverAnswer = clientSocket.send(queryData);
        try {
            Room room = this.objectMapper.readValue(serverAnswer, Room.class);
            return room;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;
    }

    public void addRoom(Room room) {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("addRoom");
        queryData.getAllParamList().add(room);

        String serverAnswer = clientSocket.send(queryData);

    }

    public Room clonerRoom(Room room) {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("clonerRoom");
        queryData.getAllParamList().add(room);
        String serverAnswer = clientSocket.send(queryData);
        try {
            Room cloneRoom = this.objectMapper.readValue(serverAnswer, Room.class);
            return room;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;
    }

    public void exportRoom(String path) {
        QueryData queryData=new QueryData();
        queryData.setSomeMethod("exportRoom");
        queryData.getAllParamList().add(path);
        String serverAnswer = clientSocket.send(queryData);
    }

    public void importRoom(String path) {
        QueryData queryData=new QueryData();
        queryData.setSomeMethod("importRoom");
        queryData.getAllParamList().add(path);
        String serverAnswer = clientSocket.send(queryData);
    }

    public List<Room> getRoomCapacitySorting() {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getRoomCapacitySorting");

        String serverAnswer = clientSocket.send(queryData);
        try {
            List<Room> listRoom = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return listRoom;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;
    }

    public List<Room> getRoomCostSorting() {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getRoomCostSorting");

        String serverAnswer = clientSocket.send(queryData);
        try {
            List<Room> listRoom = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return listRoom;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;

    }

    public List<Room> getRoomStarsSorting() {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getRoomStarsSorting");

        String serverAnswer = clientSocket.send(queryData);
        try {
            List<Room> listRoom = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return listRoom;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;

    }

    public List<Room> getArrayRoomCapacitySorting(List<Room> roomList){

    QueryData queryData=new QueryData();
        queryData.setSomeMethod("getArrayRoomCapacitySorting");

    String serverAnswer = clientSocket.send(queryData);
        try {
        List<Room> listRoom = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
        });
        return listRoom;
    } catch (IOException e) {
        this.queryData.getAllParamList().clear();
    }
        return null;


    }

    public List<Room> getArrayRoomCostSorting(List<Room> roomList) {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getArrayRoomCostSorting");
        String serverAnswer = clientSocket.send(queryData);
        try {
            List<Room> listRoom = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return listRoom;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;
    }

    public List<Room> getArrayRoomStarsSorting(List<Room> roomList) {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getArrayRoomStarsSorting");
        String serverAnswer = clientSocket.send(queryData);
        try {
            List<Room> listRoom = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Room>>() {
            });
            return listRoom;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;

    }

    public List<Service> getAllHotelServices() {

        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getAllHotelServices");
        String serverAnswer = clientSocket.send(queryData);
        try {
            List<Service> listService = this.objectMapper.readValue(serverAnswer, new TypeReference<List<Service>>() {
            });
            return listService;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;

    }

    public void addHotelService(Service someService) {
        QueryData queryData=new QueryData();
        queryData.setSomeMethod("addHotelService");
        queryData.getAllParamList().add(someService);
        String serverAnswer = clientSocket.send(queryData);
    }

    public List<GuestServiceInfo> getAllGuestServicesInfo(Guest guest) {
        QueryData queryData=new QueryData();
        queryData.setSomeMethod("getAllGuestServicesInfo");
        queryData.getAllParamList().add(guest);
        String serverAnswer = clientSocket.send(queryData);
        try {
            List<GuestServiceInfo> listService = this.objectMapper.readValue(serverAnswer, new TypeReference<List<GuestServiceInfo>>() {
            });
            return listService;
        } catch (IOException e) {
            this.queryData.getAllParamList().clear();
        }
        return null;
    }

}
