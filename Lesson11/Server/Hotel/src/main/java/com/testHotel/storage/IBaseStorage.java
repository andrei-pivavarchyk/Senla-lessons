package com.testHotel.storage;


import com.testHotel.entity.Entity;

import java.util.List;

public interface IBaseStorage<T extends Entity> {
    void addEntity(T entity);
     void removeEntity(int id);
     T getEntity(int id);
     void updateEntity(T entity);
     List<T> getAllEntities();

}
