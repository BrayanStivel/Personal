package com.example.ActCapas.service;

import java.util.List;

import com.example.ActCapas.dto.ProveedorDTO;

public interface ProveedorService {
    List<ProveedorDTO> findAll();
    ProveedorDTO findById(Long id);
    ProveedorDTO save(ProveedorDTO proveedorDTO);
    void delete(Long id);
}
