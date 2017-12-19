package com.testHotel.storage;


import com.testHotel.entity.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseStorage<T extends Entity> implements IBaseStorage<T>,Serializable {
    private List<T> entityList = new ArrayList<T>();


    public void addEntity(T entity) {

        this.entityList.add(entity);

    }

    public void removeEntity(int id) {

    }

    public T getEntity(int id) {
        return this.entityList.get(id);
    }


    public void updateEntity(T entity) {
    }

    public List<T> getAllEntities() {
        return this.entityList;
    }

}
