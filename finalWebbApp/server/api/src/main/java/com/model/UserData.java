package com.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.sql.Delete;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_data")
public class UserData extends WebEntity {

    private User user;
    private String name;
    private String surname;
    private String patronymic;

    private Role role;
    private String email;
    private Long phone;
    private Address address;
    private List<Book> favorites;
    private List<Feedback> feedbackList;

    public UserData() {
    }

    public UserData(User user,
                    String name,
                    String surname,
                    String patronymic,

                    Role role,
                    String email,
                    Long phone,
                    Address address
    ) {
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.favorites = new ArrayList<>();
        this.feedbackList = new ArrayList<>();
    }

    public UserData(Integer id,
                    User user,
                    String name,
                    String surname,
                    String patronymic,

                    Role role,
                    String email,
                    Long phone,
                    Address address) {
        super(id);
        this.user = user;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.favorites = new ArrayList<Book>();
        this.feedbackList = new ArrayList<Feedback>();
    }

    public UserData(User user, Address address) {
        this.address = address;
        this.user = user;
    }

    @JsonIgnore
    @JoinColumn(name = "user_id", updatable = false)
    @OneToOne
    public User getUser() {
        return user;
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

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    @Enumerated
    @Column(name = "role", columnDefinition = "smallint")
    public Role getRole() {
        return role;
    }

    @JoinColumn(name = "address")
    @OneToOne
    public Address getAddress() {
        return address;
    }

    @Column(name = "phone")
    public Long getPhone() {
        return phone;
    }

    @JsonIgnore
    @Transient
    @OneToMany
    @JoinTable(
            name = "user_data_book",
            joinColumns = @JoinColumn(name = "user_data_id"),
            inverseJoinColumns = @JoinColumn(name = "favorites_id")
    )
    public List<Book> getFavorites() {
        return favorites;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userData")
    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setFavorites(List<Book> wantToBuy) {
        this.favorites = wantToBuy;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (user != null ? !user.equals(userData.user) : userData.user != null) return false;
        if (name != null ? !name.equals(userData.name) : userData.name != null) return false;
        if (surname != null ? !surname.equals(userData.surname) : userData.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(userData.patronymic) : userData.patronymic != null) return false;
        if (role != userData.role) return false;
        if (email != null ? !email.equals(userData.email) : userData.email != null) return false;
        if (phone != null ? !phone.equals(userData.phone) : userData.phone != null) return false;
        if (address != null ? !address.equals(userData.address) : userData.address != null) return false;
        return favorites != null ? favorites.equals(userData.favorites) : userData.favorites == null;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (favorites != null ? favorites.hashCode() : 0);
        return result;
    }
}
