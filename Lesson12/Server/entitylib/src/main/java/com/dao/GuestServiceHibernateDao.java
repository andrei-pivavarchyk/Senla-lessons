package com.dao;

import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GuestServiceHibernateDao extends BaseHibernateDao<GuestServiceInfo>{


    public Collection<GuestServiceInfo> getAllServices()  {
        List<GuestServiceInfo> guestServicetList = new ArrayList<GuestServiceInfo>();
        guestServicetList = getSession().createCriteria(GuestServiceInfo.class).list();
        return guestServicetList;
    }

    public Collection<Service> getAllServicesByGuest(Guest guest){
List<Service> list= new ArrayList<Service>();
        list =getSession().createCriteria(GuestServiceInfo.class)
                .add(Restrictions.like("guest", guest)).list()
               ;
System.out.println(list);
        return null;
    }
    public GuestServiceInfo getEntityById(Integer id)  {
        GuestServiceInfo entity = null;
        entity = (GuestServiceInfo) getSession().load(GuestServiceInfo.class, id);
        return entity;
    }
}
