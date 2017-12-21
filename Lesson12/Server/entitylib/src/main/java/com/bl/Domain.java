package com.bl;

import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import com.entity.ServiceType;
import org.hibernate.Session;

import java.util.Date;
import java.sql.SQLException;



public class Domain {

    public static void main(String[] args) throws SQLException {

        Service serviceEntity=new Service( 46,ServiceType.EAT,"fgjfd",7887);

        Guest guest=new Guest(46,"dfsfs","dsf");
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(3,guest,serviceEntity,new Date());

        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(guest);
        session.delete(serviceEntity);
        session.delete(guestServiceInfo);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }

}