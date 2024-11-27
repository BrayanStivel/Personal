package com.example.ActCapas.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proveedorId;  // Cambiar 'id' por 'proveedorId'

    private String nombre;
    private String telefono;
    private String email;
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;

}
