package com.proyecto.FlujoDeCaja.entities;

import java.util.Date;

public class Transaction {
    private long id;
    private String concept;
    private float amount;
    private Date createdAt;
    private Date updatedAt;

    public Transaction (long id, String concept, float amount, Date createdAt, Date updatedAt){
        this.id = id;
        this.concept = concept;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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