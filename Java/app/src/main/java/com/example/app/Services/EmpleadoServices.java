package com.example.app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.Entity.Empleado;
import com.example.app.Repository.EmpleadoRepository;

@Service
public class EmpleadoServices {

    @Autowired 
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> obtenerPorId(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado guardar(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
    public Empleado actualizar(Long id, Empleado empleadoActualizado) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(empleadoActualizado.getNombre());
                    empleado.setApellido(empleadoActualizado.getApellido());
                    empleado.setTelefono(empleadoActualizado.getTelefono());
                    empleado.setCorreoElectronico(empleadoActualizado.getCorreoElectronico());
                    empleado.setDireccionResidencia(empleadoActualizado.getDireccionResidencia());
                    empleado.setSalario(empleadoActualizado.getSalario());
                    return empleadoRepository.save(empleado);
                }).orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
    }

    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}
