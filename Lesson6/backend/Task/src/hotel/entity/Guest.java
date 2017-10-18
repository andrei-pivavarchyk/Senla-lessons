package hotel.entity;

import org.apache.log4j.Logger;

public class Guest extends Entity {
    private String name;
    private String surname;

    public Guest(int id, String name, String surName) {
        super(id);
        this.name = name;
        this.surname = surName;

      //  System.out.println(new StringBuilder(String.valueOf(this)).append(" was created"));
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
