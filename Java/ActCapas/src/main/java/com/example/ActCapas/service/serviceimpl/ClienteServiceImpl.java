package com.example.ActCapas.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActCapas.dto.ClienteDTO;
import com.example.ActCapas.entity.Cliente;
import com.example.ActCapas.repository.ClienteRepository;
import com.example.ActCapas.service.ClienteService; 

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream()
                .map(cliente -> new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo()))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO findById(Long id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        return cliente != null ? new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo()) : null;
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDTO.getNombre());
        cliente.setCorreo(clienteDTO.getCorreo());
        clienteRepository.save(cliente);
        return new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo());
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        // Buscar el cliente existente
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            // Actualizar el cliente
            cliente.setNombre(clienteDTO.getNombre());
            cliente.setCorreo(clienteDTO.getCorreo());
            clienteRepository.save(cliente);
            // Retornar el cliente actualizado
            return new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo());
        }
        return null;
    }
}
