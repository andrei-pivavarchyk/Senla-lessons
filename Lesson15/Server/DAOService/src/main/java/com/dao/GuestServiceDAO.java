package com.dao;

import com.entity.Guest;

import com.entity.GuestServiceInfo;
import com.entity.Service;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.List;

public class GuestServiceDAO extends BaseDAO<GuestServiceInfo> implements IGuestServiceDAO {
    public GuestServiceDAO() {
        super("GuestServiceInfo");
    }

    public List<Service> getAllGuestServices(Guest guest, TypeSorting typeSorting) {
        Query createQuery = super.getSession().createQuery(" from GuestServiceInfo where guest=:param");
        createQuery.setParameter("param", guest);
        if(typeSorting.getType()!=TypeSorting.NO_SORTING.getType()){
            String query=createQuery.getQueryString();
            query= query.concat(" order by :type");
            createQuery.setParameter("type", typeSorting.getType());
        }

        List<GuestServiceInfo> guestServiceInfoList = createQuery.list();
        List<Service> serviceList = new ArrayList<Service>();
        for (GuestServiceInfo gs : guestServiceInfoList) {
            serviceList.add(gs.getService());
        }
        return serviceList;
    }

    public List<GuestServiceInfo> getAllGuestServiceInfo(Guest guest, TypeSorting typeSorting) {
        Query createQuery = super.getSession().createQuery(" from GuestServiceInfo where guest=:param");
        createQuery.setParameter("param", guest);
        if(typeSorting.getType()!=TypeSorting.NO_SORTING.getType()){
            String query=createQuery.getQueryString();
            query= query.concat(" order by :type");
            createQuery.setParameter("type", typeSorting.getType());
        }
        List<GuestServiceInfo> guestServiceInfoList = createQuery.list();
        return guestServiceInfoList;
    }

    public void deleteServicesByGuest(Guest guest) {
        super.getSession().beginTransaction();
        Query createQuery = super.getSession().createQuery(" delete GuestServiceInfo where guest =:param ");
        createQuery.setParameter("param", guest);
        createQuery.executeUpdate();
        super.getSession().getTransaction().commit();
    }

}
