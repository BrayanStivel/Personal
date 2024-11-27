package com.example.ActCapas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ActCapas.entity.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
    Inventario findByProductoId(Long productoId);
}
