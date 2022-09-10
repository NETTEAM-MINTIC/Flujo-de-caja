package com.proyecto.FlujoDeCaja.repositories;


import com.proyecto.FlujoDeCaja.entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



//comunicación con la BD
@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {
//Es Long el tipo del segundo parámetro, porque el Id de Enterprise es long
}