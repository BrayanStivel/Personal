package com.example.ActCapas.service;

import java.util.List;

import com.example.ActCapas.dto.CategoriaDTO;

public interface CategoriaService {
    List<CategoriaDTO> findAll();
    CategoriaDTO findById(Long id);
    CategoriaDTO save(CategoriaDTO categoriaDTO);
    void delete(Long id);
    CategoriaDTO update(Long id, CategoriaDTO categoriaDTO);
}
