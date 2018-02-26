package com.daoAPI;


public interface IBaseDAO <T> {
    void addEntity(T entity) throws Exception;
    void updateEntity(T entity) throws Exception;
    void deleteEntity(Integer id) throws Exception;

     T getEntityById(Integer id) throws Exception;
}
