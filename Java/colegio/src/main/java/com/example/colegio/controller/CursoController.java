package com.example.colegio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.colegio.entity.Curso;
import com.example.colegio.entity.Profesor;
import com.example.colegio.service.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "verCursos";
    }

    @GetMapping("/crear")
    public String crearCurso(Model model) {
        model.addAttribute("curso", new Curso());
        List<Profesor> profesores;
        profesores = cursoService.findAllProfesores();
        model.addAttribute("profesores", profesores);
        return "crearCurso"; 
    }

    @PostMapping("/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoService.save(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/{id}")
    public String verCurso(@PathVariable Long id, Model model) {
        Curso curso = cursoService.findById(id);
        model.addAttribute("curso", curso);
        return "verCurso";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id) {
        cursoService.delete(id);
        return "redirect:/cursos";
    }
}
