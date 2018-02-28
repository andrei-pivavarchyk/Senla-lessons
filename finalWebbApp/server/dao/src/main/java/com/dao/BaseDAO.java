package com.dao;

import com.daoAPI.IBaseDAO;
import com.model.WebEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public abstract class BaseDAO<T extends WebEntity> implements IBaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public BaseDAO(Class clazz)  {
        this.persistentClass = clazz;
    }

    public BaseDAO() throws Exception {
    }

    public void addEntity(T entity) throws Exception {
        getSession().save(entity);

    }

    public void updateEntity(T entity) throws Exception {
        getSession().update(entity);
    }

    public void deleteEntity(Integer id) throws Exception{
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        getSession().delete(entity);
    }

    public T getEntityById(Integer id) throws Exception {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        return entity;
    }

    public List<T> getAllEntities()throws Exception {
        List<T> entityList=new ArrayList<T>();
        entityList= getSession().createCriteria(persistentClass).list();
        return entityList;
    }

    public Class getEntityClass() {
        return this.persistentClass;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
