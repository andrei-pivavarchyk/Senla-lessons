import com.dao.*;
import com.entity.*;

import java.util.*;


public class Main {
    public static void main(String[] args){
     /*
*/

        ServiceDAO serviceHibernateDao=new ServiceDAO();
        GuestDAO guestHibernateDao=new GuestDAO();
        GuestServiceDAO guestServiceHibernateDao=new GuestServiceDAO();
        RoomDAO roomHibernateDao=new RoomDAO();
        GuestRoomInfoDAO guestRoomHibernateDao=new GuestRoomInfoDAO();
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(2018,2,3);
        Date departureDate=gregorianCalendar.getTime();
        Service serviceEntity1=new Service(1, ServiceType.EAT,"hjjjjjfc",1);
        Guest guest=new Guest(2,"Bob","bob");
        Room room =new Room(77,34,4,1);
        Guest guest1=new Guest("Fd","fd");
       guestHibernateDao.addEntity(guest);
        GuestRoomInfo guestRoomInfo=new GuestRoomInfo(1,guest,room,new Date(),departureDate,true);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(1,guest,serviceEntity1,new Date());
        roomHibernateDao.addEntity(room);
      guestRoomHibernateDao.addEntity(guestRoomInfo);
guestHibernateDao.getEntityById(2);
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

