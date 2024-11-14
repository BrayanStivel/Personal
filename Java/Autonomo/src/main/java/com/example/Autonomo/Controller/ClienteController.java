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
import com.example.Autonomo.Service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public String listarClientes(Model model) {
        List<Cliente> clientes = clienteService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "clientes/clientes"; // Ruta correcta para la plantilla
    }

    // Crear un nuevo cliente
    @GetMapping("/crear")
    public String crearCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/crearCliente"; // Ruta correcta para la plantilla
    }

    // Guardar un cliente
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.createCliente(cliente);
        return "redirect:/clientes"; // Redirige a la lista de clientes después de guardar
    }

    // Ver detalles de un cliente
    @GetMapping("/{id}")
    public String verCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "clientes/verCliente"; // Ruta correcta para la plantilla
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return "redirect:/clientes"; // Redirige a la lista de clientes después de eliminar
    }
}
