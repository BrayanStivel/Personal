package com.example.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.Entity.Empleado;
import com.example.app.Services.EmpleadoServices;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoServices empleadoServices;

    @GetMapping("/lista")
public String listarEmpleados(Model model) {
    List<Empleado> empleados = empleadoServices.obtenerTodos();
    model.addAttribute("empleados", empleados);
    return "empleados/listaEmpleados";
}

    @GetMapping("/{id}")
    public String detalleEmpleado(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoServices.obtenerPorId(id).orElse(null);
        model.addAttribute("empleado", empleado);
        return "empleados/detalle";
    }
}
