package com.dao;

import java.util.List;


public interface IBaseDAO <T> {
    List<T> getAllEntities(TypeSorting sorting);
    void addEntity(T object);
    void removeEntity(T object);
    T getEntity(int id);
    void updateEntity(T object);
    String getPrimaryKey();

}
