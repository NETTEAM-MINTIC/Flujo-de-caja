package com.Neteam.Movimientos.controller;

import com.Neteam.Movimientos.modelo.Empresa;
import com.Neteam.Movimientos.modelo.Movimiento;
import com.Neteam.Movimientos.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService servicio;

    public EmpresaController(EmpresaService servicio){

        this.servicio = servicio;
    }
/*
    // pasa al front
    @GetMapping("/empresas")
    public List<Empresa> EnterpriseList(){

        return servicio.getEnterpriseList();
    }*/



    @GetMapping("/empresa/{id}")
    public Empresa Empresa (@PathVariable("id") Long id){
        System.out.print(id);
        return servicio.getEnterprise(id);
        //return new ResponseEntity<>(servicio.getEnterprise(id), HttpStatus.OK);//getEnterprise(id);
    }


    /*
    @PostMapping("/empresa")
    public Empresa createEnterprise(@RequestBody Empresa empresa){
        //la anotación requestBody permite que lo que se reciba se adapte al tipo de dato necesitado
        return this.servicio.createEnterprise(empresa);
    }*/

    @PostMapping("/empresa")
    public RedirectView createEntreprise(@ModelAttribute Empresa empresa, Model model){
        model.addAttribute(empresa);
        this.servicio.createEnterprise(empresa);
        return new RedirectView("/empresas");
    }

    @DeleteMapping("/empresa/{id}")
    private RedirectView deleteEnterprise(@PathVariable("id") long id){
        this.servicio.eliminarEmpresa(id);
        return new RedirectView("/empresas");
    }

    @PatchMapping("/empresa/{id}")
    public Empresa createEnterprise(@PathVariable("id") Long id, @RequestBody Empresa empresa){
        //la anotación requestBody permite que lo que se reciba se adapte al tipo de dato necesitado
        return this.servicio.updateEnterprise(id, empresa);
    }
}

