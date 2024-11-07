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

import com.example.colegio.entity.Profesor;
import com.example.colegio.service.ProfesorService;


@Controller
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public String listarProfesores(Model model) {
        List<Profesor> profesores = profesorService.findAll();
        model.addAttribute("profesores", profesores);
        return "verProfesores";
    }

    @GetMapping("/crear")
    public String crearProfesorForm(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "crearProfesor";
    }

    @PostMapping("/guardar")
    public String guardarProfesor(@ModelAttribute Profesor profesor) {
        profesorService.save(profesor);
        return "redirect:/profesores";
    }

    @GetMapping("/{id}")
    public String verProfesor(@PathVariable Long id, Model model) {
        Profesor profesor = profesorService.findById(id);
        model.addAttribute("profesor", profesor);
        return "verProfesor";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return "redirect:/profesores";
    }
}
