

import java.util.ArrayList;

public class Room {
    private int number;
    private int capacity;
    private RoomStatus status = RoomStatus.free;
    private int stars;
    private int cost;
    private ArrayList<Guest> allGuests;





    public Room(int number,int cost, int capacity,int stars) {
        this.number = number;
        this.cost=cost;
        this.capacity=capacity;
        this.stars = stars;
        allGuests=new ArrayList<Guest>();



    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }
    public void addGuest(Guest guest){
        this.allGuests.add(guest);
        this.status= RoomStatus.reserved;
    }

    public void outGuest(Guest guest){
        if(allGuests.contains(guest)){this.setStatus(RoomStatus.free);}
        else{System.out.println(Literals.guestNotFoundInRoom);}
    }
    public void setCost(int cost){
        this.cost=cost;
    }
    public int getCost(){
        return this.cost;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getNumber(){
        return this.number;
    }
    public int getStars(){
        return this.stars;
    }


}
