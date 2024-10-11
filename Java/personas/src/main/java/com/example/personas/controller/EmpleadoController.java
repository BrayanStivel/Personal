package com.example.personas.controller;

import com.example.personas.entity.Empleado;
import com.example.personas.entity.Rol;
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

    @GetMapping("/crear")
    public String mostrarFormularioCreacionEmpleado(Model model) {
        model.addAttribute("roles", rolService.obtenerTodosLosRoles());
        return "empleados/crearEmpleado";
    }

    @PostMapping
    public String crearEmpleado(@ModelAttribute Empleado empleado) {
        empleadoService.crearEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = empleadoService.obtenerTodosLosEmpleados();
        model.addAttribute("empleados", empleados);
        return "empleados/listarEmpleados";
    }
}
