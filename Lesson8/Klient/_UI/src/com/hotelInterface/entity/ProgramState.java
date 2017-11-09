package com.hotelInterface.entity;



import com.queryService.hotelEntity.Room;
import com.queryService.hotelEntity.Service;

import java.io.Serializable;
import java.util.List;

public class ProgramState implements Serializable{
    private List<Room> roomList;
    private List<Service> serviceList;

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }
}
