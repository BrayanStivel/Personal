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
import com.example.Autonomo.Service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String listarCategorias(Model model) {
        List<Categoria> categorias = categoriaService.getAllCategorias();
        model.addAttribute("categorias", categorias);
        return "Categoria/categorias";
    }

    @GetMapping("/crear")
    public String crearCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "Categoria/crearCategoria";
    }

    // Guardar una nueva categoría
    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.createCategoria(categoria);
        return "redirect:/categorias";
    }

    // Ver detalles de una categoría
    @GetMapping("/{id}")
    public String verCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getCategoriaById(id).orElse(null);
        model.addAttribute("categoria", categoria);
        return "Categoria/categorias"; 
    }

    // Eliminar una categoría
    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id, Model model) {
        try {
            categoriaService.deleteCategoria(id);
        } catch (DataIntegrityViolationException ex) {
            model.addAttribute("error", ex.getMessage());
            return "Categoria/categorias";
        }
        return "redirect:/categorias";
    }

    // actualización de categoría
    @GetMapping("/editar/{id}")
    public String editarCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getCategoriaById(id).orElse(null);
        if (categoria != null) {
            model.addAttribute("categoria", categoria);
            return "Categoria/editarCategoria";
        }
        return "redirect:/categorias";
    }

    // Guardar la categoría actualizada
    @PostMapping("/actualizar/{id}")
    public String actualizarCategoria(@PathVariable Long id, @ModelAttribute Categoria categoriaDetalles) {
        Categoria categoriaActualizada = categoriaService.updateCategoria(id, categoriaDetalles);
        if (categoriaActualizada != null) {
            return "redirect:/categorias";
        }
        return "redirect:/categorias";
    }
}
