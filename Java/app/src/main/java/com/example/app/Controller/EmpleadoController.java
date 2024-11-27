package com.example.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/nuevo")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/crearEmpleado";
    }

    @PostMapping("/guardar")
    public String guardarEmpleado(Empleado empleado) {
        empleadoServices.guardar(empleado);
        return "redirect:/empleados/lista"; 
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoServices.obtenerPorId(id).orElse(null);
        if (empleado == null) {
            return "redirect:/empleados/lista";
        }
        model.addAttribute("empleado", empleado);
        return "empleados/editarEmpleado";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable Long id, Empleado empleado) {
        empleadoServices.actualizar(id, empleado);
        return "redirect:/empleados/lista";
    }
    @GetMapping("/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable Long id) {
        empleadoServices.eliminar(id);
        return "redirect:/empleados/lista";
    }
}
