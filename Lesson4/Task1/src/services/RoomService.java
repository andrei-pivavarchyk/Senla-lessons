package services;


import Storage.IGuestRoomInfoStorage;
import Storage.IGuestStorage;
import Storage.IRoomStorage;
import Storage.RoomStorage;
import comparator.RoomCapacityComparator;
import comparator.RoomCostComparator;
import comparator.RoomStarsComparator;
import entity.Guest;
import entity.GuestRoomInfo;
import entity.Room;
import entity.RoomStatus;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class RoomService implements IRoomService{


private IRoomStorage roomStorage;
private IGuestRoomInfoStorage guestRoomInfoStorage;
private IGuestStorage guestStorage;
private int guestRoomInfoCount=0;

public RoomService(IRoomStorage roomStorage,IGuestRoomInfoStorage guestRoomInfoStorage,IGuestStorage guestStorage){
    this.roomStorage=roomStorage;
    this.guestRoomInfoStorage=guestRoomInfoStorage;
    this.guestStorage=guestStorage;

}

public void addRoom(Room room){
    this.roomStorage.addEntity(room);
}

public  List<Room> getAllRooms(){

  return this.roomStorage.getAllEntities();

}



    public ArrayList<Room> getRoomCostSorting(List<Room> roomList) {
    ArrayList<Room> copyArray = new ArrayList<Room>(roomList);
    copyArray.sort(new RoomCostComparator());
    return copyArray;
}

    public ArrayList<Room>getRoomCapacitySorting(List<Room> roomList){
    ArrayList<Room> copyArray=new ArrayList<Room>(roomList);
        copyArray.sort(new RoomCapacityComparator());
        return copyArray;
    }

    public ArrayList<Room> getRoomStarsSorting(List<Room> roomList) {
        ArrayList<Room> copyArray = new ArrayList<Room>(roomList);
        copyArray.sort(new RoomStarsComparator());
        return copyArray;
    }

    public Room getRoomByNumber(int roomNumber){
        for(Room room: this.roomStorage.getAllEntities()){
            if(room.getNumber()==roomNumber){
                return room;
            }
        }
        return null;
    }

    public void addGuest(int roomNumber, Guest guest,int year,int month,int day){

        Room room= this.getRoomByNumber(roomNumber);
        if(room!=null){
            room.setStatus(RoomStatus.reserved);
            room.getGuests().add(guest);
            Calendar calendar = Calendar.getInstance();
            Date arrivalDate=calendar.getTime();
            GuestRoomInfo guestRoomInfo=new GuestRoomInfo(this.guestRoomInfoCount,arrivalDate,guest,room,year,month,day);

            this.guestRoomInfoCount++;
            this.guestRoomInfoStorage.addEntity(guestRoomInfo);
            this.guestStorage.addEntity(guest);

        }
        else{
            System.out.println("There is no room with this number");
        }

    }

    public void departureGuest ( Guest guest){

      List<GuestRoomInfo> allGuestRoomInfo=  this.guestRoomInfoStorage.getAllEntities();
      for(GuestRoomInfo guestRoomInfo:allGuestRoomInfo){
          if(guestRoomInfo.getGuest().equals(guest)){
              guestRoomInfo.setStillLiving(false);
              guestRoomInfo.setDepartureDate(new Date());
          }
      }

    }

    public ArrayList<Room> getFreeRooms(){
        ArrayList<Room> freeRooms=new ArrayList<Room>();
        for(Room room:this.roomStorage.getAllEntities()){
            if(room.getStatus().equals(RoomStatus.free)){
                freeRooms.add(room);
            }
        }
        return freeRooms;
    }

    public void printFreeRoomsCount(){
        int count=0;
        for(Room room: this.roomStorage.getAllEntities()){
            if(room.getStatus().equals(RoomStatus.free)){
                count++;
            }
        }
        System.out.println( new StringBuilder("All free rooms count:").append(count));
    }

    public ArrayList<Room> getFreeRoomsByDate(int year,int month,int day){
        ArrayList<Room> freeRoomsByDate=this.getFreeRooms();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month,day);
        for(GuestRoomInfo guestRoomInfo:this.guestRoomInfoStorage.getAllEntities()){
            if(guestRoomInfo.getDepartureDate().compareTo(calendar.getTime())==-1){
              freeRoomsByDate.add( guestRoomInfo.getRoom());
            }
        }

return freeRoomsByDate;
    }

    public ArrayList<GuestRoomInfo> getThreeLastGuests(int roomNumber){

        ArrayList<GuestRoomInfo> guestRoomInfoList=new ArrayList<GuestRoomInfo>();

        Room room=this.getRoomByNumber(roomNumber);

        for (int i = room.getGuests().size(), k = 0; i > 0 && k < 3; i--, k++) {
            Guest guest = room.getGuests().get(i - 1);

            for(GuestRoomInfo guestRoomInfo:this.guestRoomInfoStorage.getAllEntities()){
                if(guestRoomInfo.getGuest().equals(guest)){
                    guestRoomInfoList.add(guestRoomInfo);
                }
            }
        }

       return guestRoomInfoList;
    }

    public void setRoomCost(int roomNumber,int cost){
        Room room=this.getRoomByNumber(roomNumber);
        room.setCost(cost);
    }
}




