package com.dao;


import com.entity.HotelEntity;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BaseDAO<T extends HotelEntity> implements IBaseDAO<T> {
    private SessionFactory factory = Factory.getSessionFactory();
    private Session session = factory.openSession();
    private Class<T> persistentClass;
    public String tableName;

    public BaseDAO(String tableName, Class persistentClass) {
        this.persistentClass = persistentClass;
        this.tableName = tableName;
    }

    public Class getEntityClass() {
        return this.persistentClass;
    }

    public void addEntity(T entity) {
        Transaction transaction = getSession().beginTransaction();
        session.save(entity);
        transaction.commit();
    }

    public void updateEntity(T entity) {
        Transaction transaction = getSession().beginTransaction();
        session.update(entity);
        transaction.commit();
    }

    public void deleteEntity(Integer id) {
        Transaction transaction = getSession().beginTransaction();

        T object = (T) session.createCriteria(persistentClass)
                .add(Restrictions.like("id", id)).uniqueResult();
        System.out.println(object);
        session.delete(object);
        transaction.commit();
    }

    public List<T> getAllEntities(TypeSorting sorting) {
        Criteria criteria = session.createCriteria(persistentClass);
        if (sorting != TypeSorting.NO_SORTING) {
            criteria.addOrder(Order.desc(sorting.getType()));
        }
        List<T> entityList = criteria.list();
        return entityList;
    }

    public T getEntityById(Integer id) {
        Transaction transaction = getSession().beginTransaction();
        Criteria criteria = session.createCriteria(persistentClass)
                .add(Restrictions.like("id", id));
        transaction.commit();
        return  (T)criteria.uniqueResult();
    }

    public Session getSession() {
        return session;
    }
    public String getTableName() {
        return tableName;
    }
}
