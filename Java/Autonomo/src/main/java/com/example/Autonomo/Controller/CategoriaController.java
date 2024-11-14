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
        return "Categoria/categorias"; // Cambiado para que use la vista en templates/categorias
    }

    @GetMapping("/crear")
    public String crearCategoria(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "Categoria/crearCategoria"; // Cambiado para que use la vista en templates/categorias
    }

    @PostMapping("/guardar")
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.createCategoria(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/{id}")
    public String verCategoria(@PathVariable Long id, Model model) {
        Categoria categoria = categoriaService.getCategoriaById(id).orElse(null);
        model.addAttribute("categoria", categoria);
        return "Categoria/categorias"; // Cambiado para que use la vista en templates/categorias
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return "redirect:/categorias";
    }
}
