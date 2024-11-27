package com.example.ActCapas.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ActCapas.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
