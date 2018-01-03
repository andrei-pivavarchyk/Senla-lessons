package com.dao;


import com.entity.Guest;
import com.entity.HotelEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BaseDAO<T extends HotelEntity> implements IBaseDAO<T> {


    private SessionFactory factory = Factory.getSessionFactory();
    private Session session = factory.openSession();
    private Class<T> persistentClass;
    public  String tableName;

    public BaseDAO(String tableName) {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
                this.tableName=tableName;
    }

    public Class getEntityClass() {
        return this.persistentClass;
    }


    public void addEntity(T entity) {
        getSession().beginTransaction();
        session.save(entity);
        getSession().getTransaction().commit();
    }

    public void updateEntity(T entity) {
        getSession().beginTransaction();
        session.update(entity);
        getSession().getTransaction().commit();
    }

    public void deleteEntity(T entity) {
        getSession().beginTransaction();
        session.delete(entity);
        getSession().getTransaction().commit();
    }

    public List<T> getAllEntities( TypeSorting sorting) {

     getSession().beginTransaction();
        Query createQuery = getSession().createQuery(" from "+getTableName()+" order by :sorting ");

        if(sorting!=TypeSorting.NO_SORTING){
            createQuery.setParameter("sorting",sorting.getType());
        }
        List <T> entityList=createQuery.list();
      getSession().getTransaction().commit();
        return entityList;
    }


    public T getEntityById(Integer id) {
        getSession().beginTransaction();
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        getSession().getTransaction().commit();
        return entity;
    }

    public Session getSession() {
        return session;
    }

    public String getTableName() {
        return tableName;
    }
}
