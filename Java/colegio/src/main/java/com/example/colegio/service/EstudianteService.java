package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.colegio.entity.Estudiante;
import com.example.colegio.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // Obtener todos los estudiantes
    public List<Estudiante> findAll() {
        return estudianteRepository.findAll(); 
    }

    // Obtener un estudiante por ID
    public Estudiante findById(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    // Guardar o actualizar un estudiante
    public Estudiante save(Estudiante estudiante) {

        if (!StringUtils.hasText(estudiante.getNombre()) || !StringUtils.hasText(estudiante.getApellido())) {
            throw new IllegalArgumentException("Nombre y apellido son obligatorios.");
        }

        // Validación simple de correo electrónico
        if (!isValidEmail(estudiante.getCorreo_electronico())) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }

        return estudianteRepository.save(estudiante); 
    }

    // Eliminar un estudiante
    public void delete(Long id) {
        if (!estudianteRepository.existsById(id)) {
            throw new IllegalArgumentException("No se encontró el estudiante con ID: " + id);
        }
        estudianteRepository.deleteById(id);
    }

    // Validación básica de correo electrónico
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
}
