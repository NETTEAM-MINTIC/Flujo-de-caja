package com.Neteam.Movimientos.repository;

import com.Neteam.Movimientos.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,Long> {

    Usuario findByCorreo(String correo); //esta línea es para que haya una búsqueda por email durante el proceso de login
}
