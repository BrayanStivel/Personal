package com.example.Autonomo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    // Crear un nuevo cliente
    public Cliente createCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Actualizar un cliente
    @Transactional
    public Cliente updateCliente(Long id, Cliente clienteDetalles) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(id);
        
        if (clienteExistente.isPresent()) {
            Cliente cliente = clienteExistente.get();
            cliente.setNombre(clienteDetalles.getNombre());
            cliente.setCorreo_electronico(clienteDetalles.getCorreo_electronico());
            cliente.setTelefono(clienteDetalles.getTelefono());
            return clienteRepository.save(cliente);
        }
        
        return null;
    }

    // Eliminar un cliente
    @Transactional
    public void deleteCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
