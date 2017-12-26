package com.bl;

import com.dao.GuestHibernateDao;
import com.dao.GuestServiceHibernateDao;
import com.dao.RoomHibernateDao;
import com.dao.ServiceHibernateDao;
import com.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;


public class Domain {

    public static void main(String[] args) throws SQLException {
        ServiceHibernateDao serviceHibernateDao=new ServiceHibernateDao();
        GuestHibernateDao guestHibernateDao=new GuestHibernateDao();
        GuestServiceHibernateDao guestServiceHibernateDao=new GuestServiceHibernateDao();
        RoomHibernateDao roomHibernateDao=new RoomHibernateDao();

        GregorianCalendar gregorianCalendar = new GregorianCalendar();
      gregorianCalendar.set(2018,2,3);
      Date departureDate=gregorianCalendar.getTime();

        Service serviceEntity1=new Service( ServiceType.EAT,"hjjjjjfc",1);
        Guest guest=new Guest(1,"dfsfs","dsf");
        Room room =new Room(1,3,4,1);

        GuestRoomInfo guestRoomInfo=new GuestRoomInfo(guest,room,new Date(),departureDate,true);
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(guest,serviceEntity1,new Date());
/*
        serviceHibernateDao.addEntity(serviceEntity1);
        roomHibernateDao.addEntity(room);
        guestHibernateDao.addEntity(guest);
        guestServiceHibernateDao.addEntity(guestServiceInfo);

*/guestServiceHibernateDao.deleteServicesByGuest(guest);


    }
}