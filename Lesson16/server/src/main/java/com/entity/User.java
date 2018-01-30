package com.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Proxy;
import javax.persistence.*;

@Proxy(lazy = false)
@Entity
@Table(name = "user_autifification")
public class User extends WebEntity {

    private String login;
    private String password;
    // @JsonBackReference

    public User(@JsonProperty("login") String login,@JsonProperty("password") String password) {
        this.login = login;
        this.password = password;
    }

    @JsonCreator
    public User(@JsonProperty("id") Integer id, @JsonProperty("login") String login, @JsonProperty("password") String password) {
        super(id);
        this.login = login;
        this.password = password;
    }

    public User() {
    }


    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /* @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL,orphanRemoval = true)

     public List<GuestRoomInfo> getGuestRoomInfoList() {
         return guestRoomInfoList;
     }

     @OneToMany(mappedBy = "guest", cascade = CascadeType.ALL)

     public List<GuestServiceInfo> getGuestServiceInfoList() {
         return guestServiceInfoList;
     }


     public void setGuestRoomInfoList(List<GuestRoomInfo> guestRoomInfoList) {
         this.guestRoomInfoList = guestRoomInfoList;
     }

     public void setGuestServiceInfoList(List<GuestServiceInfo> guestServiceInfoList) {
         this.guestServiceInfoList = guestServiceInfoList;
     }
 */
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
        int result = (int) getId();
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
