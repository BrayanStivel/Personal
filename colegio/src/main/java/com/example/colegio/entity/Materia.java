package com.example.colegio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name= "Materias")
@NoArgsConstructor
@AllArgsConstructor
public class Materia {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idMateria;
    private String nombre_Materia;
    private String hora_incio;
    private String hora_fin;
    private String hora_;
    

    @ManyToOne 
    @JoinColumn (name= "idCurso")
    private Curso curso;

}
