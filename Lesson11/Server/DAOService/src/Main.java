import com.dao.*;
import com.testHotel.entity.Guest;


public class Main {
    public static void main(String[] args){
        GuestRoomInfoDAO guestDAO=new GuestRoomInfoDAO();
        RoomDAO roomDAO=new RoomDAO();
        GuestDAO guestDAO1=new GuestDAO();
        GuestServiceDAO guestServiceDAO=new GuestServiceDAO();
        Guest guest=new Guest(1,"bob","jjj");
     //  guestServiceDAO.removeEntity();
       // System.out.println(guestDAO.getAllEntities(TypeSorting.BY_DEPARTURE_DATE));


    }

    }


