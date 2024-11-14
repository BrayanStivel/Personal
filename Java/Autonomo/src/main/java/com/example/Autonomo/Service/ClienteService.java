package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Autonomo.Entity.Cliente;
import com.example.Autonomo.Repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Obtener todos los clientes
    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    // Obtener un cliente por su ID
    public Optional<Cliente> getClienteById(Long Id) {
        return clienteRepository.findById(Id);
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente
    public Cliente updateCliente(Long Id, Cliente cliente) {
        if (clienteRepository.existsById(Id)) {
            cliente.setIdCliente(Id); 
            return clienteRepository.save(cliente);
        }
        return null;
    }

    // Eliminar un cliente
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
