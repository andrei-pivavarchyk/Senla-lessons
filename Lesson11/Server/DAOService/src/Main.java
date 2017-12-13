import com.dao.*;
import com.dependencyService.DependencyService;
import com.testHotel.service.IRoomService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        GuestRoomInfoDAO guestDAO=new GuestRoomInfoDAO();
        RoomDAO roomDAO=new RoomDAO();
        System.out.println(guestDAO.getAllEntities(TypeSorting.BY_DEPARTURE_DATE));


    }

    }


