package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Materia;
import com.example.colegio.repository.MateriaRepository;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        materiaRepository.deleteById(id);
    }
}
