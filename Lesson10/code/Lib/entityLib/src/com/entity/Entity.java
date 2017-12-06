package com.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable {

    public Integer id;

    public Entity(int id){
        this.id=id;
    }

    public Entity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}