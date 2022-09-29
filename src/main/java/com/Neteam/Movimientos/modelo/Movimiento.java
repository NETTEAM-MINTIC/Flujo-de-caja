package com.Neteam.Movimientos.modelo;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.yaml.snakeyaml.DumperOptions;

import javax.naming.Name;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Movimiento {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movimientoID")
    private Long id;
    private String concepto;
    private float cantidad;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Empresa_id")
    private Empresa empresa;

    public Movimiento() {
    }

    public Movimiento(Long id, String concepto, float cantidad, Date created_at, Date updated_at, Empresa empresa) {
        this.id = id;
        this.concepto = concepto;
        this.cantidad = cantidad;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
