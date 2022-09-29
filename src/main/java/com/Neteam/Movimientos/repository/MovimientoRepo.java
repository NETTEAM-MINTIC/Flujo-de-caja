package com.Neteam.Movimientos.repository;

import com.Neteam.Movimientos.modelo.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepo extends JpaRepository<Movimiento,Long> {

    @Query("Select m from Movimiento m where Empresa_id=?1")
    public List<Movimiento> movimientosFindIdEmpresa(Long id);
}

