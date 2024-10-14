package com.example.personas.service;

import com.example.personas.model.Empleado;
import com.example.personas.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerEmpleado(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Optional<Empleado> actualizarEmpleado(Long id, Empleado empleado) {
        return empleadoRepository.findById(id).map(e -> {
            e.setNombre(empleado.getNombre());
            e.setApellido(empleado.getApellido());
            e.setRol(empleado.getRol());
            return empleadoRepository.save(e);
        });
    }

    public boolean eliminarEmpleado(Long id) {
        if (empleadoRepository.existsById(id)) {
            empleadoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
