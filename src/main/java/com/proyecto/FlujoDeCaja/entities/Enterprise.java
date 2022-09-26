package com.proyecto.FlujoDeCaja.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "document", unique = true)
    private String document;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    //Inyección de dependencias

   // @OneToMany (mappedBy = "id", fetch = FetchType.LAZY)
    //private List<User> users; //es el mismo Employee

  //  @OneToOne
    //JoinColumn(name = "user_id")


    //@Column(name = "transaction")
    //El mappedBy, es importante que el nombre coincida con el de la BD?
//    @OneToMany (mappedBy = "id", fetch = FetchType.LAZY)
  //  private List<Transaction> transactions;

    @Column(name = "created_at")
    private Date created_at;

    @Column(name = "updated_at")
    private Date updated_at;

    //El sistema exige un sistema constructor vacío
    public Enterprise(){

    }

    public Enterprise(String name, String document, String phone, String address){
        this.setName(name);
        this.setDocument(document);
        this.setPhone(phone);
        this.setAddress(address);
        //setUsers(new ArrayList<User>());
        //setTransactions(new ArrayList<Transaction>());
        setCreated_at(new Date());
        setUpdated_at(new Date());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /*
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }*/



    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}

