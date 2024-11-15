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

import com.example.colegio.entity.Estudiante;
import com.example.colegio.entity.Materia;
import com.example.colegio.entity.Notas;
import com.example.colegio.service.EstudianteService;
import com.example.colegio.service.MateriaService;
import com.example.colegio.service.NotaService;

@Controller
@RequestMapping("/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private MateriaService materiaService;

    @GetMapping
    public String listarNotas(Model model) {
        List<Notas> notas = notaService.findAll();
        model.addAttribute("notas", notas);
        return "verNotas";
    }

    @GetMapping("/crear")
    public String crearNotaForm(Model model) {
        model.addAttribute("nota", new Notas());
        List<Estudiante> estudiantes = estudianteService.findAll();
        List<Materia> materias = materiaService.findAll();
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("materias", materias);

        return "crearNota"; 
    }

    @PostMapping("/guardar")
    public String guardarNota(@ModelAttribute Notas notas) {
    notaService.save(notas);
    return "redirect:/notas"; 
}

    @GetMapping("/{id}")
    public String verNota(@PathVariable Long id, Model model) {
        Notas notas = notaService.findById(id);
        model.addAttribute("nota", notas);
        return "verNota"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarNota(@PathVariable Long id) {
        notaService.delete(id);
        return "redirect:/notas";
    }
}
