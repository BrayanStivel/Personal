package com.example.Autonomo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Autonomo.Entity.OrdenDeCompra;

public interface OrdenDeCompraRepository extends JpaRepository<OrdenDeCompra, Long> {

    boolean existsByProductoIdProducto(Long idProducto);
    boolean existsByClienteIdCliente(Long idCliente);
}
