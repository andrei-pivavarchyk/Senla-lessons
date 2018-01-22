package com.dao;


import com.entity.HotelEntity;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDAO<T extends HotelEntity> implements IBaseDAO<T> {
    private Class<T> persistentClass;
    private String tableName;

    public BaseDAO(String tableName, Class persistentClass) {
        this.persistentClass = persistentClass;
        this.tableName = tableName;
    }

    public void addEntity(T entity) {
        getSession().save(entity);
    }

    public void updateEntity(T entity) {
        getSession().update(entity);
    }

    public void deleteEntity(Integer id) {
        T object = (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.like("id", id)).uniqueResult();
        getSession().delete(object);
    }

    public List<T> getAllEntities(TypeSorting sorting) {
        Criteria criteria = getSession().createCriteria(persistentClass);
        if (sorting != TypeSorting.NO_SORTING) {
            criteria.addOrder(Order.desc(sorting.getType()));
        }
        List<T> entityList = criteria.list();
        return entityList;
    }

    public T getEntityById(Integer id) {
        Criteria criteria = getSession().createCriteria(persistentClass)
                .add(Restrictions.like("id", id));
        T object = (T) criteria.uniqueResult();
        return object;
    }

    public Session getSession() {
        return Factory.getSession();
    }

    public Class getEntityClass() {
        return this.persistentClass;
    }


}
