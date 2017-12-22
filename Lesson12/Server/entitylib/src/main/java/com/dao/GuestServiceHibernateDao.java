package com.dao;

import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
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
        List<Service> services=new ArrayList<Service>();
List<GuestServiceInfo> list= new ArrayList<GuestServiceInfo>();
        list =getSession().createCriteria(GuestServiceInfo.class)
                .add(Restrictions.like("guest", guest))

                .list();
for(GuestServiceInfo guestServiceInfo:list){
    services.add(guestServiceInfo.getService());
}

System.out.println(services.get(0));
        return null;
    }
    public GuestServiceInfo getEntityById(Integer id)  {
        GuestServiceInfo entity = null;
        entity = (GuestServiceInfo) getSession().load(GuestServiceInfo.class, id);
        return entity;
    }
}
