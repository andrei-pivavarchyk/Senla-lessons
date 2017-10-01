package Domain.Entities;

import Domain.Services.Contracts.IRoomService;

public class Hotel {
    private String title;
    private IRoomService roomService;

    public Hotel(String title, IRoomService roomService) {
        this.title = title;
        this.roomService = roomService;
    }

    public void setName(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Hotel: %s.", title);
    }
}