package com.example.Autonomo.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_proveedor")
    private long idProveedor;
    private String nombre;
    private String telefono;
    private String direccion;


}
