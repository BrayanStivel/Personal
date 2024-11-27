package com.example.ActCapas.dto;

import java.util.Date;
import java.util.List;

public class OrdenCompraDTO {
    private Long ordenCompraId;  // Cambiar 'id' por 'ordenCompraId'
    private Long clienteId;
    private List<Long> productosIds;
    private Date fecha;

    public OrdenCompraDTO(Long ordenCompraId, Long clienteId, List<Long> productosIds, Date fecha) {
        this.ordenCompraId = ordenCompraId;
        this.clienteId = clienteId;
        this.productosIds = productosIds;
        this.fecha = fecha;
    }

    public Long getOrdenCompraId() {
        return ordenCompraId;
    }

    public void setOrdenCompraId(Long ordenCompraId) {
        this.ordenCompraId = ordenCompraId;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<Long> getProductosIds() {
        return productosIds;
    }

    public void setProductosIds(List<Long> productosIds) {
        this.productosIds = productosIds;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
