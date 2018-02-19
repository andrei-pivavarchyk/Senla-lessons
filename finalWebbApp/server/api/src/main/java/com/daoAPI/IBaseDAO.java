package com.daoAPI;


public interface IBaseDAO <T> {
    void addEntity(T entity) throws Exception;
    void updateEntity(T entity) throws Exception;
    void deleteEntity(Long id) throws Exception;
    // List<T> getAllEntities( TypeSorting sorting);
     T getEntityById(Long id) throws Exception;
}
