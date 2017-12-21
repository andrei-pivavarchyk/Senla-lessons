package com.dao;

import com.bl.Factory;
import com.entity.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ServiceHibernateDao extends BaseHibernateDao {
    private SessionFactory factory= Factory.getSessionFactory();


    public Collection<Service> getAllServices()  {
        List<Service> service = new ArrayList<Service>();
        service = getSession().createCriteria(Service.class).list();
        return service;
    }

    public Service getEntityById(Integer id)  {
        Service entity = null;
        entity = (Service) getSession().load(Service.class, id);
        return entity;
    }

}
