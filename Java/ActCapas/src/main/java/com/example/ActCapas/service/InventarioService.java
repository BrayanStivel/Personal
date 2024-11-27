package com.example.ActCapas.service;

import java.util.List;

import com.example.ActCapas.dto.InventarioDTO;

public interface InventarioService {
    List<InventarioDTO> findAll();

    InventarioDTO findById(Long id);

    InventarioDTO save(InventarioDTO inventarioDTO);

    InventarioDTO update(Long id, InventarioDTO inventarioDTO);

    void delete(Long id);
}
