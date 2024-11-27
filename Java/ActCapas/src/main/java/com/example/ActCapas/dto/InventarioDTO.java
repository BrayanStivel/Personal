package com.example.ActCapas.dto;

public class InventarioDTO {
    private Long id;
    private Long productoId;
    private int cantidad;

    public InventarioDTO(Long id, Long productoId, int cantidad) {
        this.id = id;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
