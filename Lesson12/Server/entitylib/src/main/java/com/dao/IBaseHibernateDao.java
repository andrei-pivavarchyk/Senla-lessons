package com.dao;

public interface IBaseHibernateDao<T> {
    void addEntity(T entity);
    void updateEntity(T entity);
    T getEntityById(Long id);
    void deleteEntity(T entity);

}
