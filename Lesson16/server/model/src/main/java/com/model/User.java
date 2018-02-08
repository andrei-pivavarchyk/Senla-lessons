package com.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_autifification")
public class User extends WebEntity {

    private String login;
    private String password;
    // @JsonBackReference

    public User(@JsonProperty("id") Long id, @JsonProperty("login") String login, @JsonProperty("password") String password) {
        super(id);
        this.login = login;
        this.password = password;
    }


    public User( String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
    }


    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        if (getId() != that.getId()) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 666;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
