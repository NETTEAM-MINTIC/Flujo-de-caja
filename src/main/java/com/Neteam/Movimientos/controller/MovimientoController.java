package com.Neteam.Movimientos.controller;

import com.Neteam.Movimientos.modelo.Movimiento;
import com.Neteam.Movimientos.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimientoController {

    @Autowired
    MovimientoService movimientoService;


    @GetMapping("/empresa/{id}/movimientos")
    private List<Movimiento> verMovimientoPorEmpresa(@PathVariable("id") Long id) {
        return movimientoService.movimientosPorIdEmpresa(id);
    }

    @GetMapping("/movimientos")
    private List<Movimiento> verMovimiento(){
        return movimientoService.verMovimiento();
    }

    @PostMapping("/movimiento")
    private void crearMovimiento(@RequestBody Movimiento movimiento){
        movimientoService.guardarMovimiento(movimiento);
    }

    @DeleteMapping("/movimiento/{id}")
    private void eliminarMovimiento(@PathVariable("id") Long id){
        movimientoService.eliminarMovimiento(id);
    }

    @PatchMapping("/movimiento/{id}")
    private Movimiento actualizarMovimiento(@PathVariable("id") Long id, @RequestBody Movimiento movimiento){
        Movimiento movimiento1 = movimientoService.verMovimientoPorId(id);
        movimiento1.setConcepto(movimiento.getConcepto());
        movimiento1.setCantidad(movimiento.getCantidad());
        movimiento1.setCreated_at(movimiento1.getCreated_at());
        movimiento1.setUpdated_at(movimiento1.getUpdated_at());
        return movimientoService.guardarMovimiento(movimiento1);
    }
}

