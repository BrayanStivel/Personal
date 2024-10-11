package com.example.personas.service;

import com.example.personas.entity.Empleado;
import com.example.personas.entity.Rol;
import com.example.personas.repository.EmpleadoRepository;
import com.example.personas.repository.RolRepository;
import com.example.personas.serviceinterface.EmpleadoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements EmpleadoServiceInterface {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private RolRepository rolRepository;

    // Método para crear un nuevo empleado
    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    // Método para obtener empleados por rol
    @Override
    public List<Empleado> obtenerEmpleadosPorRol(String nombreRol) {
        Rol rol = rolRepository.findByNombre(nombreRol)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return empleadoRepository.findByRol(rol);
    }

    // Método para obtener todos los empleados
    @Override
    public List<Empleado> obtenerTodosLosEmpleados() {
        return empleadoRepository.findAll();
    }
}
