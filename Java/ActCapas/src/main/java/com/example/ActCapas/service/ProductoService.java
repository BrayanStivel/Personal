package com.example.ActCapas.service;

import java.util.List;

import com.example.ActCapas.dto.ProductoDTO;

public interface ProductoService {

    List<ProductoDTO> findAll();

    ProductoDTO findById(Long id);

    ProductoDTO save(ProductoDTO productoDTO);

    ProductoDTO update(Long id, ProductoDTO productoDTO);

    void delete(Long id);
}
