package com.Neteam.Movimientos.service;

import com.Neteam.Movimientos.modelo.Movimiento;
import com.Neteam.Movimientos.repository.MovimientoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    MovimientoRepo movimientoRepo;

    public Movimiento guardarMovimiento(Movimiento movimiento){
        movimientoRepo.save(movimiento);
        return movimiento;
    }

    public List<Movimiento> verMovimiento(){
        List<Movimiento> movimientos = new ArrayList<>();
        movimientos.addAll(movimientoRepo.findAll());
        return movimientos;
    }

    public void eliminarMovimiento(Long id){
        movimientoRepo.deleteById(id);
    }

    public Movimiento verMovimientoPorId(Long id){
        return movimientoRepo.findById(id).get();
    }

    public List<Movimiento> movimientosPorIdEmpresa(Long id){
        return movimientoRepo.movimientosFindIdEmpresa(id);
    }

}
