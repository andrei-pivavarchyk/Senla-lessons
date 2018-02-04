package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "user_data")
public class UserData extends WebEntity {

    private User user;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;

    public UserData() {
    }

    @JsonCreator
    public UserData(
            @JsonProperty("user") User user,
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("patronymic") String patronymic,
            @JsonProperty("dateOfBirth") Date dateOfBirth) {

        super(id);
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    @JsonCreator
    public UserData(
            @JsonProperty("user") User user,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname,
            @JsonProperty("patronymic") String patronymic,
            @JsonProperty("dateOfBirth") Date dateOfBirth) {

        this.user = user;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }

    @Basic
    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Basic
    @Column(name = "surname")
    public String getPatronymic() {
        return patronymic;
    }

    @Basic
    @Column(name = "patronymic")
    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
