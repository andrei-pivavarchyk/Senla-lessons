package com.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends WebEntity {

    private String login;
    private String password;
    private Boolean user_active;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.user_active = true;
    }

    public User(Long id, String login, String password) {
        super(id);
        this.login = login;
        this.password = password;
        this.user_active = true;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    
    @Column(name = "user_active", columnDefinition = "BIT")
    public Boolean getUser_active() {
        return user_active;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setUser_active(Boolean user_active) {
        this.user_active = user_active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
