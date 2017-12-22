package com.dao;

public interface IBaseHibernateDao<T> {
    void addEntity(T entity);
    void updateEntity(T entity);
    void deleteEntity(T entity);

}
