import com.dao.*;
import com.entity.Guest;


import java.util.HashSet;
import java.util.Iterator;
import java.util.List;


public class Main {
    public static void main(String[] args){
        GuestDAO guestDAO=new GuestDAO();
        List<Guest> guestList= guestDAO.getAllEntities(TypeSorting.NO_SORTING);
        System.out.println(guestList.get(0));
    }

    }


