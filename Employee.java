package com.example.appWebGraddle;
import java.util.Date;
import java.util.List;

public class Employee {
    private long id;
    private String email;
    private List<Transaction> transactions;
    private Date createdAt;
    private Date updatedAt;

    public Employee(long id, String email, List<Transaction> transactions, Date createdAt, Date updatedAt) {
        this.id = id;
        this.email = email;
        this.transactions = transactions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }








}
