package com.uvg.laboratorio3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uvg.laboratorio3.model.CantanteModel;
import com.uvg.laboratorio3.repository.CantanteRepository;

@Controller
@RequestMapping("/cantantes")
public class CantanteController {

    @Autowired
    private CantanteRepository cantanteRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("cantantes", cantanteRepo.findAll());
        return "cantante/index";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("cantante", new CantanteModel());
        return "cantante/form";
    }

    @PostMapping
    public String crear(@ModelAttribute CantanteModel cantante) {
        cantanteRepo.save(cantante);
        return "redirect:/cantantes";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        CantanteModel c = cantanteRepo.findById(id).orElseThrow();
        model.addAttribute("cantante", c);
        return "cantante/form";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute CantanteModel cantante) {
        cantante.setId(id);
        cantanteRepo.save(cantante);
        return "redirect:/cantantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        cantanteRepo.deleteById(id);
        return "redirect:/cantantes";
    }
}
