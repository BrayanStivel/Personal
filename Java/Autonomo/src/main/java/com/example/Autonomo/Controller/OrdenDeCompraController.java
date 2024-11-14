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

import com.example.Autonomo.Entity.Cliente;
import com.example.Autonomo.Entity.OrdenDeCompra;
import com.example.Autonomo.Entity.Producto;
import com.example.Autonomo.Service.ClienteService;
import com.example.Autonomo.Service.OrdenCompraService;
import com.example.Autonomo.Service.ProductoService;

@Controller
@RequestMapping("/ordenes")
public class OrdenDeCompraController {

    @Autowired
    private OrdenCompraService ordenDeCompraService;

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String listarOrdenes(Model model) {
        List<OrdenDeCompra> ordenes = ordenDeCompraService.getAllOrdenesCompra();
        model.addAttribute("ordenes", ordenes);
        return "ordenes/ordenes"; // Cambiado para que use la vista en templates/ordenes
    }

    @GetMapping("/crear")
    public String crearOrden(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("ordenDeCompra", new OrdenDeCompra());
        model.addAttribute("productos", productos);
        model.addAttribute("clientes", clientes);
        return "ordenes/crearOrden"; // Cambiado para que use la vista en templates/ordenes
    }

    @PostMapping("/guardar")
    public String guardarOrden(@ModelAttribute OrdenDeCompra ordenDeCompra) {
        ordenDeCompraService.createOrdenCompra(ordenDeCompra);
        return "redirect:/ordenes";
    }

    @GetMapping("/{id}")
    public String verOrden(@PathVariable Long id, Model model) {
        OrdenDeCompra ordenDeCompra = ordenDeCompraService.getOrdenCompraById(id).orElse(null);
        model.addAttribute("ordenDeCompra", ordenDeCompra);
        return "ordenes/verOrden"; // Cambiado para que use la vista en templates/ordenes
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarOrden(@PathVariable Long id) {
        ordenDeCompraService.deleteOrdenCompra(id);
        return "redirect:/ordenes";
    }
}
