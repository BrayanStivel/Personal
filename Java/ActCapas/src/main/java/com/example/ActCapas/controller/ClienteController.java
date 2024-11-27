package com.example.ActCapas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;  // Importar PUT para actualizar
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ActCapas.dto.ClienteDTO;
import com.example.ActCapas.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Obtener todos los clientes
    @GetMapping
    public List<ClienteDTO> getAllClientes() {
        return clienteService.findAll();
    }

    // Obtener un cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id) {
        ClienteDTO clienteDTO = clienteService.findById(id);
        if (clienteDTO != null) {
            return ResponseEntity.ok(clienteDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO savedCliente = clienteService.save(clienteDTO);
        return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
    }

    // Eliminar un cliente por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un cliente por ID
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO updatedCliente = clienteService.update(id, clienteDTO);
        if (updatedCliente != null) {
            return ResponseEntity.ok(updatedCliente);  // Si la actualización fue exitosa
        } else {
            return ResponseEntity.notFound().build();  // Si no se encontró el cliente
        }
    }
}
