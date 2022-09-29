package com.Neteam.Movimientos.modelo;

import com.fasterxml.jackson.databind.DatabindException;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuarioID")
    private Long id;

    private String correo;

    private String nombre;

    private String Cargo;

    @CreationTimestamp
    private Date createdAt;

    @UpdateTimestamp
    private Date updateAt;

   /* public Usuario(String correo, String nombre, String cargo) {
        this.correo = correo;
        this.nombre = nombre;
        this.Cargo = cargo;
    }*/
}
