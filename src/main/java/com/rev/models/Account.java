package com.rev.models;

import annotations.Column;
import annotations.PrimaryKey;
import annotations.Table;

@Table(name = "account")
public class Account {

    @PrimaryKey(name = "account_id")
    private int id;

    @Column(column = "balance")
    private String balance;

    @Column(column = "user_id")
    private int userID;

    public Account(int id, String balance, int userID) {
        this.id = id;
        this.balance = balance;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
