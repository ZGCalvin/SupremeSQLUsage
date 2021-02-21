package com.rev.models;

import annotations.Column;
import annotations.PrimaryKey;
import annotations.Table;

@Table(name = "transactions")
public class Transactions {

    @PrimaryKey(name = "transaction_id")
    private int trans_id;

    @Column(column = "trans_date")
    private String date;

    @Column(column = "amount")
    private String amount;

    @Column(column = "t_type")
    private String type;

    @Column(column = "account_id")
    private int account_id;

    public Transactions(int trans_id, String date, String amount, String type, int account_id) {
        this.trans_id = trans_id;
        this.date = date;
        this.amount = amount;
        this.type = type;
        this.account_id = account_id;
    }

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {
        this.trans_id = trans_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
