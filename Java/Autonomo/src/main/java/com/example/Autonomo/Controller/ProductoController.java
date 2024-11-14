package com.example.Autonomo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    // Listar productos
    @GetMapping
    public String listarProductos(Model model) {
        List<Producto> productos = productoService.getAllProductos();
        model.addAttribute("productos", productos);
        return "productos/productos";
    }

    // Formulario para crear un producto
    @GetMapping("/crear")
    public String crearProducto(Model model) {
        List<Categoria> categorias = categoriaService.getAllCategorias();
        List<Proveedor> proveedores = proveedorService.getAllProveedores();
        Producto producto = new Producto();  // Crea un nuevo objeto Producto
        model.addAttribute("producto", producto);  // Pasa el objeto Producto al modelo
        model.addAttribute("categorias", categorias);  // Pasa la lista de categorías
        model.addAttribute("proveedores", proveedores);  // Pasa la lista de proveedores
        return "productos/crearProducto";
    }

    // Guardar producto
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.createProducto(producto);  // Guarda el producto
        return "redirect:/productos";  // Redirige a la lista de productos
    }

    // Ver detalles de un producto
    @GetMapping("/{id}")
    public String verProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.getProductoById(id).orElse(null);
        model.addAttribute("producto", producto);
        return "productos/verProducto";
    }

    // Eliminar producto
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
        return "redirect:/productos";  // Redirige a la lista de productos después de eliminar
    }
}
