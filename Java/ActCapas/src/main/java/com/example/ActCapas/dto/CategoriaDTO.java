package com.example.ActCapas.dto;

public class CategoriaDTO {
    private Long categoriaId;  // Cambiar 'id' a 'categoriaId'
    private String nombre;

    public CategoriaDTO(Long categoriaId, String nombre) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
