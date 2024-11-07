package com.example.colegio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.colegio.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
