package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.Notas;

@Repository
public interface NotaRepository extends JpaRepository<Notas, Long> {
    void deleteByMateria_IdMateria(Long id);
}
