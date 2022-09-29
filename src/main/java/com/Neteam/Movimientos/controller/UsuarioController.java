package com.Neteam.Movimientos.controller;

import com.Neteam.Movimientos.modelo.Usuario;
import com.Neteam.Movimientos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    private List<Usuario> verUsuarios() {
        return usuarioService.verUsuarios();
    }

    @PostMapping("/usuario")
    private void crearUsuario(@RequestBody Usuario usuario){
        usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/usuario/{id}")
    private Usuario usuarioPorID(@PathVariable("id")Long id){
        System.out.print(id);
        return usuarioService.usuarioporID(id);
    }

    @DeleteMapping("usuario/{id}")
    private boolean borrarUsuario(@PathVariable("id") Long id){
        return usuarioService.borrarUsuario(id);
    }

    @PatchMapping ("usuario/{id}")
    private Usuario actualizarUsuario(@PathVariable ("id") Long id, @RequestBody Usuario usuario){
        return usuarioService.actualizarUsuario(id, usuario);
    }


}