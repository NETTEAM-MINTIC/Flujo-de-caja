package com.proyecto.FlujoDeCaja.services;


import com.proyecto.FlujoDeCaja.entities.User;

import com.proyecto.FlujoDeCaja.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService{
//Se incluyen las dependencias

    @Autowired
    private UserRepository repositoryUser;

//get
    public List<User> getAll()
    {
        return (List<User>) repositoryUser.findAll();
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
        User New=this.repositoryUser.findById(Id).orElse(null);
        if(New!=null){
            New.setId(Id);
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
        User New=repositoryUser.findById(id).orElse(null);
        boolean bandera=true;
        if(New==null){
           this.repositoryUser.deleteById(id);
            bandera=false;
        }

        return bandera;

    }


}
