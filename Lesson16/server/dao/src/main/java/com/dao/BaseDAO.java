package com.dao;

import com.dao.api.IBaseDAO;
import com.model.WebEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAO<T extends WebEntity> implements IBaseDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> persistentClass;

    public BaseDAO(Class clazz) {
        this.persistentClass = clazz;
    }

    public BaseDAO() {
    }

    public Class getEntityClass() {
        return this.persistentClass;
    }

    public void addEntity(T entity) {
        this.sessionFactory.getCurrentSession().save(entity);
    }

    public void updateEntity(T entity) {
        getSession().update(entity);
    }

    public void deleteEntity(Long id) {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        getSession().delete(entity);
    }

    public T getEntityById(Long id) {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        return entity;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
