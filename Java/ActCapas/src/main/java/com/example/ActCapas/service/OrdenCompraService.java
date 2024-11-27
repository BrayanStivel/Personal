package com.example.ActCapas.service;

import java.util.List;

import com.example.ActCapas.dto.OrdenCompraDTO;

public interface OrdenCompraService {

    List<OrdenCompraDTO> findAll();

    OrdenCompraDTO findById(Long id);

    OrdenCompraDTO save(OrdenCompraDTO ordenCompraDTO);

    void delete(Long id);
}
