package com.example.personas.controller;

import com.example.personas.model.Empleado;
import com.example.personas.service.EmpleadoService;
import com.example.personas.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private RolService rolService;

    @GetMapping
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.listarEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados"; // nombre de la vista
    }

    @GetMapping("/form")
    public String mostrarFormularioEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        model.addAttribute("roles", rolService.listarRoles());
        return "empleado-form"; // nombre de la vista
    }

    @GetMapping("/{id}")
    public String mostrarEmpleado(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoService.obtenerEmpleado(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        model.addAttribute("empleado", empleado);
        model.addAttribute("roles", rolService.listarRoles());
        return "empleado-form"; // nombre de la vista
    }

    @PostMapping
    public String guardarEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados"; // redirigir a la lista de empleados
    }

    @DeleteMapping("/delete/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados"; // redirigir a la lista de empleados
    }
}
