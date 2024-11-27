package com.example.ActCapas.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ActCapas.dto.CategoriaDTO;
import com.example.ActCapas.entity.Categoria;
import com.example.ActCapas.repository.CategoriaRepository;
import com.example.ActCapas.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<CategoriaDTO> findAll() {
        // Convertir las entidades a DTOs y devolverlas
        return categoriaRepository.findAll().stream()
                .map(categoria -> new CategoriaDTO(categoria.getCategoriaId(), categoria.getNombre()))
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO findById(Long categoriaId) {
        Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);
        return categoria != null ? new CategoriaDTO(categoria.getCategoriaId(), categoria.getNombre()) : null;
    }

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria.getCategoriaId(), categoria.getNombre());
    }

    @Override
    public void delete(Long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

    @Override
    public CategoriaDTO update(Long categoriaId, CategoriaDTO categoriaDTO) {
        // Encontrar la categoría existente
        Categoria categoria = categoriaRepository.findById(categoriaId).orElse(null);

        if (categoria != null) {
            // Actualizar la categoría
            categoria.setNombre(categoriaDTO.getNombre());
            categoriaRepository.save(categoria);
            return new CategoriaDTO(categoria.getCategoriaId(), categoria.getNombre());
        }

        return null;
    }
}
