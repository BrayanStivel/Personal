package com.example.Autonomo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Autonomo.Entity.Categoria;
import com.example.Autonomo.Entity.Producto;
import com.example.Autonomo.Entity.Proveedor;
import com.example.Autonomo.Service.CategoriaService;
import com.example.Autonomo.Service.ProductoService;
import com.example.Autonomo.Service.ProveedorService;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "productos/productos";
    }

    @GetMapping("/crear")
    public String crearProducto(Model model) {
        List<Categoria> categorias = categoriaService.getAllCategorias();
        List<Proveedor> proveedores = proveedorService.getAllProveedores();
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        model.addAttribute("proveedores", proveedores);
        return "productos/crearProducto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.createProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.getProductoById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "productos/verProducto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id, Model model) {
        try {
            productoService.deleteProducto(id);
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("error", ex.getMessage());
            return "productos/productos";
        }
        return "redirect:/productos";
    }
}
