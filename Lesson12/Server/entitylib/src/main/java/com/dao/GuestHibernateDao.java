package com.dao;

import com.entity.Guest;
import com.entity.Service;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GuestHibernateDao extends BaseHibernateDao<Guest>{


    public Collection<Guest> getAllServices()  {
        List<Guest> guestList = new ArrayList<Guest>();
        guestList = getSession().createCriteria(Service.class).list();
        return guestList;
    }
    public Guest getEntityById(Integer id)  {
        Guest entity = null;
        entity = (Guest) getSession().load(Guest.class, id);
        return entity;
    }
}
