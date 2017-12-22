package com.bl;

import com.dao.GuestHibernateDao;
import com.dao.GuestServiceHibernateDao;
import com.dao.RoomHibernateDao;
import com.dao.ServiceHibernateDao;
import com.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;
import java.sql.SQLException;



public class Domain {

    public static void main(String[] args) throws SQLException {
        ServiceHibernateDao serviceHibernateDao=new ServiceHibernateDao();
        GuestHibernateDao guestHibernateDao=new GuestHibernateDao();
        GuestServiceHibernateDao guestServiceHibernateDao=new GuestServiceHibernateDao();
        RoomHibernateDao roomHibernateDao=new RoomHibernateDao();
        Service serviceEntity1=new Service( ServiceType.EAT,"hjjjjjfc",1);
        Guest guest=new Guest("dfsfs","dsf");
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(guest,serviceEntity1,new Date());
    }

}