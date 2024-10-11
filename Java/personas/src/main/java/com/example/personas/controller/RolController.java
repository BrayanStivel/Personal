package com.example.personas.controller;

import com.example.personas.entity.Rol;
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

    @GetMapping("/crear")
    public String mostrarFormularioCreacionRol() {
        return "roles/crearRol";
    }

    @PostMapping
    public String crearRol(@ModelAttribute Rol rol) {
        rolService.crearRol(rol);
        return "redirect:/roles";
    }

    @GetMapping
    public String listarRoles(Model model) {
        List<Rol> roles = rolService.obtenerTodosLosRoles();
        model.addAttribute("roles", roles);
        return "roles/listarRoles";
    }
}

