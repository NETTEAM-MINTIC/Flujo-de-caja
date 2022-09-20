package com.proyecto.FlujoDeCaja.services;


import com.proyecto.FlujoDeCaja.entities.Enterprise;
import com.proyecto.FlujoDeCaja.entities.User;

import com.proyecto.FlujoDeCaja.repositories.EnterpriseRepository;
import com.proyecto.FlujoDeCaja.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService{
//Se incluyen las dependencias

    @Autowired
    UserRepository repositoryUser;

//get

 public List<User> getAll()
    {
        List<User>user=new ArrayList<>();
        user.addAll(repositoryUser.findAll());
        return user;
    }
//post
    public User createUser(User newUser){
        return repositoryUser.save(newUser);
    }
//get
    public User getUser(long id)  {
        User New=repositoryUser.findById(id).orElse(null);
        return New;
    }
//patch
    public User updateUser(long Id, User editUser){
        User New = this.repositoryUser.findById(Id).orElse(null);
        if(New!=null){
            New.setId(Id);
            if (editUser.getName()!=null){
                New.setName(editUser.getName());
            }
            if(editUser.getEmail()!=null){
                New.setEmail(editUser.getEmail());
            }

            if(editUser.getUpdatedAt()!=null){
                New.setUpdatedAt(editUser.getUpdatedAt());
            }

            if(editUser.getCreatedAt()!=null){
                New.setCreatedAt(editUser.getCreatedAt());
            }
            this.repositoryUser.save(New);
         }

        return New;
    }
//delete
    public boolean deleteUser(long id){
        boolean bandera = false;
        User New=repositoryUser.findById(id).orElse(null);
        if(New!=null){
           this.repositoryUser.deleteById(id);
            bandera = true;
        }

        return bandera;

    }


}