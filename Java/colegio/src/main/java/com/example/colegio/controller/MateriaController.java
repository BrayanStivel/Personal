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
import com.example.colegio.entity.Materia;
import com.example.colegio.service.CursoService; // Asegúrate de importar el servicio de Curso
import com.example.colegio.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private CursoService cursoService; // Inyección del servicio de Curso

    @GetMapping
    public String listarMaterias(Model model) {
        List<Materia> materias = materiaService.findAll();
        model.addAttribute("materias", materias);
        return "verMaterias";
    }

    @GetMapping("/crear")
    public String crearMateriaForm(Model model) {
        model.addAttribute("materia", new Materia());
        List<Curso> cursos = cursoService.findAll(); // Obtener la lista de cursos
        model.addAttribute("cursos", cursos);
        return "crearMateria"; // Nombre de la plantilla HTML
    }

    @PostMapping("/guardar")
    public String guardarMateria(@ModelAttribute Materia materia) {
        materiaService.save(materia);
        return "redirect:/materias";
    }

    @GetMapping("/{id}")
    public String verMateria(@PathVariable Long id, Model model) {
        Materia materia = materiaService.findById(id);
        model.addAttribute("materia", materia);
        return "verMateria";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMateria(@PathVariable Long id) {
        materiaService.delete(id);
        return "redirect:/materias";
    }
}
