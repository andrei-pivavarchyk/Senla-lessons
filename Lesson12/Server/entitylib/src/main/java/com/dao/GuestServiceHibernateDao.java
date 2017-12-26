package com.dao;

import com.entity.Guest;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class GuestServiceHibernateDao extends BaseHibernateDao<GuestServiceInfo>{

public List<Service> getAllGuestServices(Guest guest){
    Query createQuery = super.getSession().createQuery(" from GuestServiceInfo where guest=:param");
    createQuery.setParameter("param", guest);
    List <GuestServiceInfo > guestServiceInfoList = createQuery.list();
    List<Service> serviceList=new ArrayList<Service>();
    for(GuestServiceInfo gs: guestServiceInfoList){
        serviceList.add(gs.getService());
    }
    return serviceList;
}

public void deleteServicesByGuest(Guest guest){

    super.getSession().beginTransaction();


    Query createQuery = super.getSession().createQuery(" delete GuestServiceInfo where guest =:param ");
  createQuery.setParameter("param", guest);
   createQuery.executeUpdate();
    super.getSession().getTransaction().commit();
}




   // Query query = session.createQuery("FROM Developer D WHERE D.id = 1");
   // List developer = query.list();





/*

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
    }*/
}
