package Entity;

public class Guest {
    private String name;
    private String surname;

    public Guest(String name, String surName) {
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