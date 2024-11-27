package com.example.ActCapas.service;

import java.util.List;

import com.example.ActCapas.dto.ClienteDTO;

public interface ClienteService {
    List<ClienteDTO> findAll();
    ClienteDTO findById(Long id);
    ClienteDTO save(ClienteDTO clienteDTO);
    void delete(Long id);
    ClienteDTO update(Long id, ClienteDTO clienteDTO); 
}
