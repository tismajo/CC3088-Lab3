package com.uvg.laboratorio3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uvg.laboratorio3.model.GeneroModel;
import com.uvg.laboratorio3.repository.GeneroRepository;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("generos", generoRepo.findAll());
        return "genero/index";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("genero", new GeneroModel());
        return "genero/form";
    }

    @PostMapping
    public String crear(@ModelAttribute GeneroModel genero) {
        generoRepo.save(genero);
        return "redirect:/generos";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        GeneroModel genero = generoRepo.findById(id).orElseThrow();
        model.addAttribute("genero", genero);
        return "genero/form";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute GeneroModel genero) {
        genero.setId(id);
        generoRepo.save(genero);
        return "redirect:/generos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        generoRepo.deleteById(id);
        return "redirect:/generos";
    }
}
