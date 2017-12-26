import com.dao.*;
import com.entity.Guest;


import java.util.HashSet;
import java.util.Iterator;


public class Main {
    public static void main(String[] args){
        GuestRoomInfoDAO guestDAO=new GuestRoomInfoDAO();
        RoomDAO roomDAO=new RoomDAO();
        GuestDAO guestDAO1=new GuestDAO();
        GuestServiceDAO guestServiceDAO=new GuestServiceDAO();
        Guest guest=new Guest("bob","jjj");
     //  guestServiceDAO.removeEntity();
       // System.out.println(guestDAO.getAllEntities(TypeSorting.BY_DEPARTURE_DATE));

        HashSet<String> countryHashSet = new HashSet<>();
        countryHashSet.add("Россия");
        countryHashSet.add("Кот-Д'Ивуар"); // любимая страна всех котов
        countryHashSet.add("Франция");
        countryHashSet.add("Гондурас");
        countryHashSet.add("Кот-Д'Ивуар"); // кот попросил добавить ещё раз для надёжности

        Iterator<String> iterator = countryHashSet.iterator();
        while (iterator.hasNext()) {

            System.out.println( iterator.next());


        }

        HashSet<Guest> hashSet=new HashSet<Guest>();
        Guest guest1=new Guest("gfdgfd","fgdgfd");
        Guest guest2=new Guest("5464654","fgdg54658568fd");

        hashSet.add(guest1);
        hashSet.add(guest2);
        hashSet.add(guest1);
       while(hashSet.iterator().hasNext()){
           System.out.println(hashSet.iterator().next());
       }
        System.out.println("end");

    }

    }


