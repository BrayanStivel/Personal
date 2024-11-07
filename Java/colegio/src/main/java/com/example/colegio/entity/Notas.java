package com.example.colegio.entity;

import jakarta.persistence.Column;
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
@Table(name= "Notas")
@NoArgsConstructor
@AllArgsConstructor
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNota;

    @ManyToOne
    @JoinColumn(name= "idEstudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name= "idMateria")
    private Materia materia;

    @Column(name = "nota")
    private double nota;

}

