package com.dao;

import com.bl.Factory;
import com.entity.Guest;
import com.entity.HotelEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BaseHibernateDao <T extends HotelEntity> {


    private SessionFactory factory= Factory.getSessionFactory();
    private Session session=factory.openSession();
    private Class<T> persistentClass;

    public BaseHibernateDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

public Class getEntityClass(){
        return this.persistentClass;
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

    public Collection<T> getAllentities()  {
        session.beginTransaction();
        List<T> guestList = new ArrayList<T>();
        guestList = getSession().createCriteria(getEntityClass()).list();
        session.getTransaction().commit();
        return guestList;
    }

    public T getEntityById(Integer id)  {
        session.beginTransaction();
        T entity = null;
        entity =(T) getSession().load(getEntityClass(), id);
        session.getTransaction().commit();
        return entity;
    }

    public Session getSession() {
        return session;
    }
}
