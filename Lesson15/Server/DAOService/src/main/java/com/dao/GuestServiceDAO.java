package com.dao;

import com.entity.Guest;

import com.entity.GuestRoomInfo;
import com.entity.GuestServiceInfo;
import com.entity.Service;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class GuestServiceDAO extends BaseDAO<GuestServiceInfo> implements IGuestServiceDAO {
    public GuestServiceDAO() {
        super("GuestServiceInfo", GuestServiceDAO.class);
    }

    public List<Service> getAllGuestServices(Guest guest, TypeSorting typeSorting) {

        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = getSession().createCriteria(GuestServiceInfo.class);
        if (typeSorting != TypeSorting.NO_SORTING) {
            criteria.addOrder(Order.desc(typeSorting.getType()));
        }
        List<Service> object = (List<Service>) criteria
                .add(Restrictions.eq("guest", guest))
                .list();
        transaction.commit();
        return object;
    }

    public List<GuestServiceInfo> getAllGuestServiceInfo(Guest guest, TypeSorting typeSorting) {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = getSession().createCriteria(GuestServiceInfo.class);
        if (typeSorting != TypeSorting.NO_SORTING) {
            criteria.addOrder(Order.desc(typeSorting.getType()));
        }
        List<GuestServiceInfo> object = (List<GuestServiceInfo>) criteria
                .add(Restrictions.eq("guest", guest))
                .list();
        transaction.commit();
        return object;
    }

    public void deleteServicesByGuest(Guest guest) {
        super.getSession().beginTransaction();
        Query createQuery = getSession().createQuery(" delete GuestServiceInfo where guest =:param ");
        createQuery.setParameter("param", guest);
        createQuery.executeUpdate();
        super.getSession().getTransaction().commit();
    }

}
