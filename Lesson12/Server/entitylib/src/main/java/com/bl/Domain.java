package com.bl;

import com.dao.GuestHibernateDao;
import com.dao.GuestServiceHibernateDao;
import com.dao.ServiceHibernateDao;
import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import com.entity.ServiceType;
import org.hibernate.Session;

import java.util.Date;
import java.sql.SQLException;



public class Domain {

    public static void main(String[] args) throws SQLException {
        ServiceHibernateDao serviceEntity=new ServiceHibernateDao();
        GuestHibernateDao guestHibernateDao=new GuestHibernateDao();
        GuestServiceHibernateDao guestServiceHibernateDao=new GuestServiceHibernateDao();

        Service serviceEntity1=new Service( 68,ServiceType.EAT,"hjjjjjfc",1);
        Service serviceEntity2=new Service( 67,ServiceType.EAT,"hjjjjjfc",1);
        Guest guest=new Guest(6,"dfsfs","dsf");
        GuestServiceInfo guestServiceInfo=new GuestServiceInfo(66,guest,serviceEntity1,new Date());
/*
        serviceEntity.addEntity(serviceEntity1);
        serviceEntity.addEntity(serviceEntity2);
        guestHibernateDao.addEntity(guest);
        guestServiceHibernateDao.addEntity(guestServiceInfo);
*/
//Guest guest1=guestHibernateDao.getEntityById(guest.getId());
        serviceEntity.addEntity(serviceEntity1);
  Service service22=serviceEntity.getEntityById(66);
    }

}