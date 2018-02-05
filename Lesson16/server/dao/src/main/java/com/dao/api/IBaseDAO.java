package com.dao.api;

import java.util.List;


public interface IBaseDAO <T> {
    void addEntity(T entity);
    void updateEntity(T entity);
    void deleteEntity(Long id);
    // List<T> getAllEntities( TypeSorting sorting);
     T getEntityById(Long id);
}
