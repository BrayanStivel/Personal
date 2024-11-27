package com.example.Autonomo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
        return "clientes/clientes";
    }

    // Crear un nuevo cliente
    @GetMapping("/crear")
    public String crearCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/crearCliente";
    }

    // Guardar un cliente
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.createCliente(cliente);
        return "redirect:/clientes";
    }

    // Ver detalles de un cliente
    @GetMapping("/{id}")
    public String verCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "clientes/verCliente"; 
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id, Model model) {
        try {
            clienteService.deleteCliente(id);
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("error", ex.getMessage());
            return "clientes/clientes";
        }
        return "redirect:/clientes";
    }

    // Mostrar el formulario de edición de cliente
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Long id, Model model) {
        Cliente cliente = clienteService.getClienteById(id).orElse(null);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clientes/editarCliente";
        }
        return "redirect:/clientes";
    }

    // Guardar el cliente actualizado
    @PostMapping("/actualizar/{id}")
    public String actualizarCliente(@PathVariable Long id, @ModelAttribute Cliente clienteDetalles) {
        Cliente clienteActualizado = clienteService.updateCliente(id, clienteDetalles);
        if (clienteActualizado != null) {
            return "redirect:/clientes";
        }
        return "redirect:/clientes";
    }
}
