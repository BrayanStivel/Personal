package com.example.app.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.Entity.Rol;
import com.example.app.Services.RolServices;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolServices rolServices;

    @GetMapping
    public String listarRoles(Model model) {
        List<Rol> roles = rolServices.obtenerTodos();
        model.addAttribute("roles", roles);
        return "roles/roles"; 
    }

    @GetMapping("/{id}")
    public String detalleRol(@PathVariable Long id, Model model) {
        Optional<Rol> rol = rolServices.obtenerPorId(id);
        model.addAttribute("rol", rol.orElse(null));
        return "roles/detalleRol"; 
    }

    @GetMapping("/nuevo")
    public String crearNuevoRol(Model model) {
        model.addAttribute("rol", new Rol());
        return "roles/nuevoRol"; 
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Rol rol) {
        rolServices.guardar(rol);
        return "redirect:/roles"; 
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        rolServices.eliminar(id);
        return "redirect:/roles"; 
    }

    @GetMapping("/editar/{id}")
    public String editarRol(@PathVariable Long id, Model model) {
        Optional<Rol> rol = rolServices.obtenerPorId(id);
        if (rol.isPresent()) {
            model.addAttribute("rol", rol.get());
            return "roles/editarRol";
        }
        return "redirect:/roles"; 
    }

    @PostMapping("/actualizar")
    public String actualizarRol(@ModelAttribute Rol rol) {
        rolServices.guardar(rol);
        return "redirect:/roles"; 
    }
}
