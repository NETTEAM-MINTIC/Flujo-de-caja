package com.proyecto.FlujoDeCaja.controllers;

import com.proyecto.FlujoDeCaja.entities.*;
import com.proyecto.FlujoDeCaja.services.EnterpriseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnterpriseController {
    @Autowired
    EnterpriseServices servicio;

    public EnterpriseController(EnterpriseServices servicio){

        this.servicio = servicio;
    }

    // pasa al front
    @GetMapping("/enterprises")
    public List<Enterprise> EnterpriseList(){

        return servicio.getEnterpriseList();
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise Empresa (@PathVariable("id") Long id){
        System.out.print(id);
        return servicio.getEnterprise(id);
        //return new ResponseEntity<>(servicio.getEnterprise(id), HttpStatus.OK);//getEnterprise(id);
    }


    @PostMapping("/enterprises")
    public Enterprise createEnterprise(@RequestBody Enterprise empresa){
        //la anotación requestBody permite que lo que se reciba se adapte al tipo de dato necesitado
        return this.servicio.createEnterprise(empresa);
    }

    @DeleteMapping("/enterprises/{id}")
    private boolean deleteEnterprise(@PathVariable("id") Long id){
        return this.servicio.eliminarEmpresa(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Enterprise createEnterprise(@PathVariable("id") Long id, @RequestBody Enterprise empresa){
        //la anotación requestBody permite que lo que se reciba se adapte al tipo de dato necesitado
        return this.servicio.updateEnterprise(id, empresa);
    }
}


