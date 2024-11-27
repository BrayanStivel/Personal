package com.example.ActCapas.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;

    @ManyToMany
    @JoinTable(
        name = "cliente_orden_compra", 
        joinColumns = @JoinColumn(name = "cliente_id"), 
        inverseJoinColumns = @JoinColumn(name = "orden_compra_id")
    )
    private List<OrdenCompra> ordenesCompra;

}
