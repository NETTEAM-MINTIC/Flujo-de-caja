package com.Neteam.Movimientos.modelo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empresa") // Nombre diferente a la clase "sobraria"
public class Empresa {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empresaID")
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "document", unique = true)
    private String document;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updated_at;



    //El sistema exige un sistema constructor vacío
    public Empresa(){

    }

    public Empresa(long id, String name, String document, String phone, String address, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

/*    public Empresa (String name, String document, String phone, String address){
        this.setName(name);
        this.setDocument(document);
        this.setPhone(phone);
        this.setAddress(address);
        //setUsers(new ArrayList<User>());
        //setTransactions(new ArrayList<Transaction>());
        setCreated_at(new Date());
        setUpdated_at(new Date());
    }*/

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
