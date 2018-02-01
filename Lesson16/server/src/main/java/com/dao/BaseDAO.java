package com.dao;

import com.dao.api.IBaseDAO;
import com.entity.WebEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class BaseDAO<T extends WebEntity> implements IBaseDAO<T> {

    private Factory factory ;
    private Class<T> persistentClass;
    public  String tableName;

    public BaseDAO(Class clazz) {
        this.persistentClass = clazz;

    }

    public Class getEntityClass() {
        return this.persistentClass;
    }


    public void addEntity(T entity) {
        getSession().save(entity);
    }

    public void updateEntity(T entity) {
        getSession().update(entity);
    }



    public void deleteEntity(Integer id) {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        getSession().delete(entity);
    }


/*
    public void deleteEntity(Integer id) {
        Transaction transaction = getSession().beginTransaction();
        Query createQuery = getSession().createQuery(" delete "+getTableName()+" where id =:param ");
        createQuery.setParameter("param", id);
        createQuery.executeUpdate();
        transaction.commit();
    }

    public List<T> getAllEntities( TypeSorting sorting) {

        Transaction transaction = getSession().beginTransaction();
        Query createQuery = getSession().createQuery(" from "+getTableName() );

        if(sorting!=TypeSorting.NO_SORTING){
            createQuery.getQueryString().concat(" order by :sorting");
            createQuery.setParameter("sorting",sorting.getType());
        }
        List <T> entityList=createQuery.list();
        transaction.commit();
        return entityList;
    }
*/

    public T getEntityById(Integer id) {
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        return entity;
    }

    public Session getSession() {
        return Factory.getSession();
    }

}
