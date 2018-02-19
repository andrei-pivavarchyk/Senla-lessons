package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_contact")
public class UserContact extends WebEntity{

    private String email;
    private Integer phone;

    public UserContact(){}

    public UserContact(String email, Integer phone) {
        this.email = email;
        this.phone = phone;
    }

    public UserContact(Long id, String email, Integer phone) {
        super(id);
        this.email = email;
        this.phone = phone;
    }
    @Column(name = "email")
    public String getEmail() {
        return email;
    }
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserContact that = (UserContact) o;

        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        return phone != null ? phone.equals(that.phone) : that.phone == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }
}
