package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Curso;
import com.example.colegio.entity.Profesor; // Importar la entidad Profesor
import com.example.colegio.repository.CursoRepository;
import com.example.colegio.repository.ProfesorRepository; // Importar el repositorio de Profesor

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public void save(Curso curso) {
        cursoRepository.save(curso);
    }

    public Curso findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        cursoRepository.deleteById(id);
    }

    // Método para obtener todos los profesores
    public List<Profesor> findAllProfesores() {
        return profesorRepository.findAll();
    }
}
