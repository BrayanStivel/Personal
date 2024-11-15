package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Materia;
import com.example.colegio.repository.MateriaRepository;
import com.example.colegio.repository.NotaRepository;

import jakarta.transaction.Transactional;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository materiaRepository;

    @Autowired
    private NotaRepository notaRepository;

    public List<Materia> findAll() {
        return materiaRepository.findAll();
    }

    public void save(Materia materia) {
        materiaRepository.save(materia);
    }

    public Materia findById(Long id) {
        return materiaRepository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(long idMateria) {
        notaRepository.deleteByMateria_IdMateria(idMateria);
        materiaRepository.deleteById(idMateria);
    }

    @Transactional
    public Materia update(Long id, Materia materiaDetalles) {
        Materia materiaExistente = materiaRepository.findById(id).orElse(null);
        
        if (materiaExistente != null) {
            materiaExistente.setNombre_Materia(materiaDetalles.getNombre_Materia());
            materiaExistente.setCurso(materiaDetalles.getCurso());
            return materiaRepository.save(materiaExistente);
        }
        
        return null;
    }
}
