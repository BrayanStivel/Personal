package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Profesor;
import com.example.colegio.repository.ProfesorRepository;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public void save(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    public Profesor findById(Long id) {
        return profesorRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        profesorRepository.deleteById(id);
    }
}
