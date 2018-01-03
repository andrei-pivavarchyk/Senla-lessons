package com.dao;

import java.util.List;


public interface IBaseDAO <T> {
    void addEntity(T entity);
    void updateEntity(T entity);
    void deleteEntity(T entity);
    List<T> getAllEntities( TypeSorting sorting);
    T getEntityById(Integer id);
}
