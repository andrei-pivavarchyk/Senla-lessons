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
    private Date dateOfBirth;

    public Author() {
    }

    public Author(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Author(Long id, String name, String surname, Date dateOfBirth) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
