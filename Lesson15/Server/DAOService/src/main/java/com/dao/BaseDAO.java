package com.dao;


import com.entity.HotelEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class BaseDAO<T extends HotelEntity> implements IBaseDAO<T> {
    private SessionFactory factory = Factory.getSessionFactory();
    private Session session = factory.openSession();
    private Class<T> persistentClass;
    public  String tableName;
    public BaseDAO(String tableName, Class persistentClass) {
        this.persistentClass=persistentClass;
                this.tableName=tableName;
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


    public T getEntityById(Integer id) {
        Transaction transaction = getSession().beginTransaction();
        T entity = null;
        entity = (T) getSession().load(getEntityClass(), id);
        transaction.commit();
        return entity;
    }

    public Session getSession() {
        return session;
    }

    public String getTableName() {
        return tableName;
    }
}
