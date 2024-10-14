package com.example.personas.controller;

import com.example.personas.model.Rol;
import com.example.personas.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listarRoles(Model model) {
        List<Rol> roles = rolService.listarRoles();
        model.addAttribute("roles", roles);
        return "roles"; // nombre de la vista
    }

    @GetMapping("/form")
    public String mostrarFormularioRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol-form"; // nombre de la vista
    }

    @GetMapping("/{id}")
    public String mostrarRol(@PathVariable Long id, Model model) {
        Rol rol = rolService.obtenerRol(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        model.addAttribute("rol", rol);
        return "rol-form"; // nombre de la vista
    }

    @PostMapping
    public String guardarRol(@ModelAttribute Rol rol) {
        rolService.guardarRol(rol);
        return "redirect:/roles"; // redirigir a la lista de roles
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return "redirect:/roles"; // redirigir a la lista de roles
    }
}
