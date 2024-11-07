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
import com.example.colegio.service.EstudianteService;



@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "verEstudiantes";
    }

    @GetMapping("/crear")
    public String crearEstudianteForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "crearEstudiante";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.save(estudiante);
        return "redirect:/estudiantes"; 
    }

    @GetMapping("/{id}")
    public String verEstudiante(@PathVariable Long id, Model model) {
        Estudiante estudiante = estudianteService.findById(id);
        model.addAttribute("estudiante", estudiante);
        return "verEstudiante"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.delete(id);
        return "redirect:/estudiantes";
    }
}
    
    
    
    
    
    
    
    


