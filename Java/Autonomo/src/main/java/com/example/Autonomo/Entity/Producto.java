package com.example.Autonomo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name= "Producto")
public class Producto {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_producto")
    public long idProducto;

    public String nombre;
    public String descripcion;
    public double precio;
    private Integer cantidadDisponible;
    private Integer cantidadReserva;


    @ManyToOne
    @JoinColumn(name = "id_Categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name ="id_proveedor")
    private Proveedor proveedor;

}
