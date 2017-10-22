package ui.entity;


import hotel.entity.*;
import hotel.storage.*;

import java.io.Serializable;
import java.util.List;

public class ProgramState implements Serializable{
    private List<Room> roomList;


    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }
}
