package com.example.Autonomo.Entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "Orden_compra")
public class OrdenDeCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_oden_Compra")
    private long idOrdenCompra;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    private Integer cantidad;
    private Double precioTotal;
    private String descripcionCompra;

    @ManyToOne
    @JoinColumn(name= "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="id_producto")
    private Producto producto;
}
