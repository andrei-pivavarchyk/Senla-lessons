import com.dao.*;
import com.entity.*;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;


public class Main {
    public static void main(String[] args) {

        ServiceDAO serviceHibernateDao = new ServiceDAO();
        GuestDAO guestHibernateDao = new GuestDAO();
        GuestServiceDAO guestServiceHibernateDao = new GuestServiceDAO();
        RoomDAO roomHibernateDao = new RoomDAO();
        GuestRoomInfoDAO guestRoomHibernateDao = new GuestRoomInfoDAO();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(2018, 2, 3);
        Date departureDate = gregorianCalendar.getTime();
        Service serviceEntity1 = new Service(1, ServiceType.EAT, "hjjjjjfc", 1);
        Guest guest = new Guest(24, "Bob", "bob");
        Room room = new Room(8,77, 34, 4, 1);
        Guest guest1 = new Guest(8, "Fd", "fd");
        GuestRoomInfo guestRoomInfo = new GuestRoomInfo(7, guest, room, new Date(), departureDate, false);
        GuestRoomInfo guestRoomInfo1 = new GuestRoomInfo(7, guest, room, new Date(), departureDate, false);
        GuestServiceInfo guestServiceInfo = new GuestServiceInfo(6, guest, serviceEntity1, new Date());

    //  Transaction tr=  Factory.getSession().beginTransaction();
     //   roomHibernateDao.deleteEntity(7);
     //   tr.commit();

      //  guestHibernateDao.addEntity(guest);
      //  guestHibernateDao.addEntity(guest);
       // guestHibernateDao.addEntity(guest);
       // guestHibernateDao.addEntity(guest);
       // guestRoomHibernateDao.addEntity(guestRoomInfo);
       // guestRoomHibernateDao.addEntity(guestRoomInfo);
       // guestRoomHibernateDao.addEntity(guestRoomInfo);
/**
 Guest Hibernate test
 */

     // guestHibernateDao.addEntity(guest);
       // guestHibernateDao.updateEntity(guest1);
        //  guestHibernateDao.deleteEntity(4);
        //  guestHibernateDao.getEntityById(3);

/**
 GuestRoomInfo
 */

        // guestRoomHibernateDao.addEntity(guestRoomInfo);
        // guestRoomHibernateDao.deleteEntity(6);
        // guestRoomHibernateDao.updateEntity(guestRoomInfo1);
        //  guestRoomHibernateDao.getEntityById(8);
        // guestRoomHibernateDao.departureGuest(guest);
        // guestRoomHibernateDao.addGuest(guestRoomInfo);



    // System.out.println( guestRoomHibernateDao.getEntityById(8).getGuest().getName());
    // System.out.println( guestRoomHibernateDao.getEntityById(8).getGuest().getName());
    // System.out.println( guestRoomHibernateDao.getEntityById(8).getGuest().getName());


        // serviceHibernateDao.addEntity(serviceEntity1);
/*
        SessionFactory factory = Factory.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.delete(guest);
        session.getTransaction().commit();
*/
        //guestHibernateDao.deleteEntity(4);
        // guestRoomHibernateDao.deleteEntity(1);
        //guestHibernateDao.addEntity(guest);
        // guestServiceHibernateDao.addEntity(guestServiceInfo);
        // guestRoomHibernateDao.addEntity(guestRoomInfo);
        //   guestRoomHibernateDao.getCurrentGuestRoomInfo(true,TypeSorting.BY_ARRIVAL_DATE);
        //guestRoomHibernateDao.deleteEntity(1);
        //guestHibernateDao.deleteEntity(1);
        //  guestServiceHibernateDao.deleteEntity(1);
        // guestRoomHibernateDao.deleteEntity(guestRoomInfo);
        // serviceHibernateDao.deleteEntity(serviceEntity1);
        // roomHibernateDao.deleteEntity(room);
        //guestHibernateDao.deleteEntity(guest);
        //   guestRoomHibernateDao.getGuestByStatus(RoomStatus.RESERVED,TypeSorting.BY_ARRIVAL_DATE);
        //guestServiceHibernateDao.getAllGuestServices(guest,TypeSorting.BY_COST);
    }

}

