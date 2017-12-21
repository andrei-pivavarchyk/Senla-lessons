package com.dao;

import com.bl.Factory;
import com.entity.HotelEntity;
import com.entity.Service;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseHibernateDao <T extends HotelEntity> {


    private SessionFactory factory= Factory.getSessionFactory();
    private Session session;

    public BaseHibernateDao() {
        session = factory.openSession();
    }

    public void addEntity(T entity)  {
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
    }

    public void updateEntity(T entity)  {
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
    }



    public void deleteEntity(T entity) {
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public Session getSession() {
        return session;
    }
}
