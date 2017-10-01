package Domain.Entities;

public class Guest extends Entity {
    private String name;
    private String surname;

    public Guest(String name, String surName, int id) {
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
        return String.format("Guest Name: %s surname: %s", this.name, this.surname);
    }
}