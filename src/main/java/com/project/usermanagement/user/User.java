package com.project.usermanagement.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.usermanagement.creditcard.CreditCard;
import org.springframework.stereotype.Component;
//import com.project.usermanagement.creditcard.CreditCard;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @Column(length = 50)
    private String email;
    private String name;
    private String password;
    @OneToMany(targetEntity = CreditCard.class, cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.LAZY)
    private List<CreditCard> creditCardList;

    public User() {
    }

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<CreditCard> getCreditCardList() {
        return creditCardList;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", creditCardList=" + creditCardList +
                '}';
    }
}
