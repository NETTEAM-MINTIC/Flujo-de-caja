package com.Neteam.Movimientos.service;

import com.Neteam.Movimientos.modelo.Usuario;
import com.Neteam.Movimientos.repository.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepo usuarioRepo;


    //Get
    public List<Usuario> verUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.addAll(usuarioRepo.findAll());
        return usuarios;
    }

    //Post
    public Usuario crearUsuario(Usuario usuario){
        usuarioRepo.save(usuario);
        return usuario;
    }

    //GetbyID
    public Usuario usuarioporID(Long id){
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        return usuario;
    }

    //Patch
    public Usuario actualizarUsuario(Long id, Usuario editarUsuario){
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        if(usuario!=null){
            usuario.setId(id);
            if(editarUsuario.getCorreo()!=null){
                usuario.setCorreo(editarUsuario.getCorreo());
            }
            usuarioRepo.save(usuario);
        }
        return usuario;
    }

    //Delete
    public boolean borrarUsuario(Long id){
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        boolean bandera = true;
        if(usuario==null){
            usuarioRepo.deleteById(id);
            bandera = false;
        }
        return bandera;
    }

    public Usuario findUserByEmail(String email){
        return this.usuarioRepo.findByCorreo(email);
    }

    public Usuario getOrCreateUser(Map<String ,Object> usuarioDatos){
        String email = (String) usuarioDatos.get("email");

        Usuario usuario = findUserByEmail(email);
        if(usuario == null){
            String nickName = (String) usuarioDatos.get("nickname");
            String picture = (String) usuarioDatos.get("picture");
            String auth0Id = (String) usuarioDatos.get("sub");


            Usuario nuevoU = new Usuario();
            nuevoU.setNombre(nickName);
            nuevoU.setCorreo(email);
            nuevoU.setCargo("Admin"); //pendiente completar

            return crearUsuario(nuevoU);
        }
        System.out.println(usuario.getCorreo());
        return usuario;
    }
}
