package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Estudiante;
import com.example.colegio.repository.EstudianteRepository;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public List<Estudiante> findAll(){
        return estudianteRepository.findAll(); 
    }

    public Estudiante findById(Long id){
        return estudianteRepository.findById(id).orElse(null);
    }
    public Estudiante save(Estudiante estudiante){
        return estudianteRepository.save(estudiante);
    }
    public void delete(Long id){
        estudianteRepository.deleteById(id);
    }



}
