package com.testHotel.storage;


import com.testHotel.entity.Entity;

import java.util.List;

public interface IBaseStorage<T extends Entity> {


    public void addEntity(T entity);
    public void removeEntity(int id);
    public T getEntity(int id);
    public void updateEntity(T entity);
    public List<T> getAllEntities();

}
