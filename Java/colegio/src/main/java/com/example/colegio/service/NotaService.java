package com.example.colegio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.colegio.entity.Notas;
import com.example.colegio.repository.NotaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    public List<Notas> findAll(){
        return notaRepository.findAll();
    }

    public Notas findById( long id){
        return notaRepository.findById(id).orElse(null);
    }
    public Notas save(Notas notas){
        return notaRepository.save(notas);
    }
    public void delete(long id){
        notaRepository.deleteById(id);
    }

}
