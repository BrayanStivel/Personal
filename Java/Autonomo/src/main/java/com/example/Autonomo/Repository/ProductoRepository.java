package com.example.Autonomo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Autonomo.Entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
