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
import com.example.colegio.service.CursoService;
import com.example.colegio.service.MateriaService;

@Controller
@RequestMapping("/materias")
public class MateriaController {

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String listarMaterias(Model model) {
        List<Materia> materias = materiaService.findAll();
        model.addAttribute("materias", materias);
        return "verMaterias";
    }

    @GetMapping("/crear")
    public String crearMateriaForm(Model model) {
        model.addAttribute("materia", new Materia());
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "crearMateria";
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

    @GetMapping("/actualizar/{id}")
public String mostrarFormularioDeActualizacion(@PathVariable("id") Long id, Model model) {
    Materia materia = materiaService.findById(id);  
    List<Curso> cursos = cursoService.findAll();  
    model.addAttribute("materia", materia);  
    model.addAttribute("cursos", cursos);    
    return "editarMateria";

}
@PostMapping("/materias/actualizar/{id}")
    public String actualizarMateria(@PathVariable("id") Long id, @ModelAttribute("materia") Materia materia) {
        // Lógica para actualizar la materia
        materiaService.update(id, materia);
        
        // Redirigir a la lista de materias o mostrar una página de éxito
        return "redirect:/materias";
    }


}