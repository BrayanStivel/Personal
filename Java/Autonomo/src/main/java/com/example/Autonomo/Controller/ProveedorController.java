package com.example.Autonomo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Autonomo.Entity.Proveedor;
import com.example.Autonomo.Service.ProveedorService;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listarProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.getAllProveedores();
        model.addAttribute("proveedores", proveedores);
        return "proveedores/proveedores"; // Cambiado para que use la vista en templates/proveedores
    }

    @GetMapping("/crear")
    public String crearProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedores/crearProveedor"; // Cambiado para que use la vista en templates/proveedores
    }

    @PostMapping("/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.createProveedor(proveedor);
        return "redirect:/proveedores";
    }

    @GetMapping("/{id}")
    public String verProveedor(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.getProveedorById(id).orElse(null);
        model.addAttribute("proveedor", proveedor);
        return "proveedores/verProveedor"; // Cambiado para que use la vista en templates/proveedores
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
    proveedorService.deleteProveedor(id);
    return "redirect:/proveedores";
}
}
