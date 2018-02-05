package com.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
            @JsonProperty("id") Long id,
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

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    public User getUser() {
        return user;
    }


    @Column(name = "date_of_birth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    @Column(name = "name")
    public String getName() {
        return name;
    }


    @Column(name = "surname")
    public String getPatronymic() {
        return patronymic;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData that = (UserData) o;
        if (getId() != that.getId()) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 666;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        return result;
    }
}
