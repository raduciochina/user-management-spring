package com.project.usermanagement.creditcard;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.usermanagement.user.User;

import javax.persistence.*;

@Entity
@Table
public class CreditCard {
    @Id
    @Column(length = 50)
    private String cardId;
    private String cardNumber;
    private String holderName;
    private String expirationDate;
    private String cvv;
    private String bankName;
    @ManyToOne
    @JoinColumn(name = "email")
    @JsonIgnore
    private User user;

    public CreditCard() {
    }

    public CreditCard(String cardId, String cardNumber, String holderName, String expirationDate, String cvv, String bankName) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.bankName = bankName;
    }

    public String getCardId() {
        return cardId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardId='" + cardId + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv='" + cvv + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
