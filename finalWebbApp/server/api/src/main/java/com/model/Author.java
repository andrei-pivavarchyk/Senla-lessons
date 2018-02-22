package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "author")
public class Author extends WebEntity {

    private String name;
    private String surname;

    public Author() {
    }

    public Author(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;

    }

    public Author(Integer id, String name, String surname, Date dateOfBirth) {
        super(id);
        this.name = name;
        this.surname = surname;

    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        return surname != null ? surname.equals(author.surname) : author.surname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
