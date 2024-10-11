package com.example.personas.repository;

import com.example.personas.entity.Empleado;
import com.example.personas.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    List<Empleado> findByRol(Rol rol);
}