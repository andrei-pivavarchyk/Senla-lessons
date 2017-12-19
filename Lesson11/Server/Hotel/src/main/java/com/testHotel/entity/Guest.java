package com.testHotel.entity;

public class Guest extends Entity {
    private String name;
    private String surname;

    public Guest(int id, String name, String surName) {
        super(id);
        this.name = name;
        this.surname = surName;

    }

    public String getName() {
        return this.name;
    }

    public String getSurName() {
        return this.surname;
    }

    public String toString() {
        return String.format("Guest  %s %s ", this.name, this.surname);

    }

}
