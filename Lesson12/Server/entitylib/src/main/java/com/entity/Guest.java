package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Guest extends Entity {
    private String name;
    private String surname;

    @JsonCreator
    public Guest(@JsonProperty("id")Integer id,@JsonProperty("name") String name,@JsonProperty("surName") String surName) {
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