package com.Neteam.Movimientos.repository;

import com.Neteam.Movimientos.modelo.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepo extends JpaRepository<Empresa, Long> {
}
