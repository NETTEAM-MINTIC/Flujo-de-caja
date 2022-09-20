package com.proyecto.FlujoDeCaja.entities;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.*;



@Entity
@Table(name = "users")
public class User {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   @Column(name="email", unique = true)
   private String email;
   @Column(name="name", unique = true)
   private String name;
  // @OneToOne(fetch = FetchType.LAZY)
   //@JoinColumn(name = "profile_id")
   //private Profile profile;

    //private Role_Name role;
    @Column(name="createAt")
    private Date createdAt;
    @Column(name="updateAt")
    private Date updatedAt;

   //@ManyToOne( fetch = FetchType.LAZY)
   //@JoinColumn(name = "enterprise_id")
   //private Enterprise enterprise;

  //@OneToMany(mappedBy = "user")
  //private List<Transaction> transaction;

    public User() {
    }

    public User( String email, String name, Date createdAt, Date updatedAt) {

        this.email = email;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public Profile getProfile() {
     //   return profile;
    //}

   /// public void setProfile(Profile profile) {
      //  this.profile = profile;
    //}

    //public Role_Name getRole() {
      //  return role;}

    //public void setRole(Role_Name role) {
      //  this.role = role;}

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

    //public Enterprise getEnterprise() {
      //  return enterprise;}

   /* public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }*/
}

