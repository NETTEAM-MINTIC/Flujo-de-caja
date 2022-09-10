package com.proyecto.FlujoDeCaja.services;


import com.proyecto.FlujoDeCaja.entities.*;
import com.proyecto.FlujoDeCaja.repositories.EnterpriseRepository;
import com.proyecto.FlujoDeCaja.repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseServices {

    @Autowired
    private EnterpriseRepository repo;
    /*Task tarea1;
    Task tarea2;
    TaskList mejorAnio;*/

    public EnterpriseServices(EnterpriseRepository repo){
        this.repo = repo;
        /*this.tarea1 = new Task("Aprender a decir no",false, LocalDate.of(2022,12,31));
        this.tarea2 = new Task("Aprender a parar",false, LocalDate.of(2022,12,31));
        this.mejorAnio = new TaskList("Propósitos este año");

        mejorAnio.AddTask(tarea1);
        mejorAnio.AddTask(tarea2);*/
    }

    //El controlador llama al servicio y este llama al repositorio
    public List<Enterprise> getEnterpriseList(){

        return this.repo.findAll();
    }


    //La sugerencia del editor fue hacer la función optional
    public Enterprise getEnterprise(Long id){
        Enterprise temporal = repo.findById(id).orElse(null);
        return temporal;//this.repo.findById(id).orElseThrow(() -> new EnterpriseNotFoundException(id));

    }
    public Enterprise createEnterprise(Enterprise nuevaEmpresa){
        return this.repo.save(nuevaEmpresa); //se guarda la nueva tarea en la bd
    }

    //para el patch
    public Enterprise updateEnterprise(long Id, Enterprise editarEmpresa){
        Enterprise temporal = this.repo.findById(Id).orElse(null);
        if(temporal!=null){
            temporal.setId(Id);
            if(editarEmpresa.getName()!=null){
                temporal.setName(editarEmpresa.getName());
            }
            if(editarEmpresa.getAddress()!=null){
                temporal.setAddress(editarEmpresa.getAddress());
            }
            if(editarEmpresa.getUpdated_at()!=null){
                temporal.setUpdated_at(editarEmpresa.getUpdated_at());
            }

            if(editarEmpresa.getCreated_at()!=null){
                temporal.setCreated_at(editarEmpresa.getCreated_at());
            }

            if(editarEmpresa.getDocument()!=null){
                temporal.setDocument(editarEmpresa.getDocument());
            }
            if(editarEmpresa.getPhone()!=null){
                temporal.setPhone(editarEmpresa.getPhone());
            }
            this.repo.save(temporal);
        }
        return temporal;

    }

    public boolean eliminarEmpresa(Long id){
        boolean bandera = false;
        Enterprise temporal = repo.findById(id).orElse(null);
        if(temporal !=null){
            this.repo.deleteById(id);
            bandera = true;
        }
        return bandera;
    }

}