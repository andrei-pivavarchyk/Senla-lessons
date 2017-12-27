package com.bl;

import com.dao.*;
import com.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;


public class Domain {

    public static void main(String[] args) throws SQLException {
        ServiceHibernateDao serviceHibernateDao=new ServiceHibernateDao();
        GuestHibernateDao guestHibernateDao=new GuestHibernateDao();
        GuestServiceHibernateDao guestServiceHibernateDao=new GuestServiceHibernateDao();
        RoomHibernateDao roomHibernateDao=new RoomHibernateDao();
GuestRoomHibernateDao guestRoomHibernateDao=new GuestRoomHibernateDao();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.set(2018,2,3);
      Date departureDate=gregorianCalendar.getTime();

        Service serviceEntity1=new Service( ServiceType.EAT,"hjjjjjfc",1);
        Guest guest=new Guest(1,"dfsfs","dsf");
        Room room =new Room(1,3,4,1);

        GuestRoomInfo guestRoomInfo=new GuestRoomInfo(guest,room,new Date(),departureDate,true);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(guest,serviceEntity1,new Date());


      //  guestRoomHibernateDao.addEntity(guestRoomInfo);
/*
        serviceHibernateDao.addEntity(serviceEntity1);
        roomHibernateDao.addEntity(room);
        guestHibernateDao.addEntity(guest);
        guestServiceHibernateDao.addEntity(guestServiceInfo);

*/



      //  guestRoomHibernateDao.addEntity(guestRoomInfo);

    // guestRoomHibernateDao.updateEntityStatus(guest,RoomStatus.FREE);
//System.out.println(guestRoomHibernateDao.getCountGuestsByStatus(RoomStatus.FREE));

        System.out.println(guestRoomHibernateDao.getGuestByStatus(RoomStatus.FREE).get(0));
    }
}