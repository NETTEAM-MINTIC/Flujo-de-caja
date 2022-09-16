package com.proyecto.FlujoDeCaja.repositories;

import com.proyecto.FlujoDeCaja.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
}
