package com.uvg.laboratorio3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uvg.laboratorio3.model.AlbumModel;
import com.uvg.laboratorio3.repository.AlbumRepository;
import com.uvg.laboratorio3.repository.CantanteRepository;

@Controller
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private CantanteRepository cantanteRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("albums", albumRepo.findAll());
        return "album/index";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("album", new AlbumModel());
        model.addAttribute("cantantes", cantanteRepo.findAll()); // <-- Agregar esto
        return "album/form";
    }

    @PostMapping
    public String crear(@ModelAttribute AlbumModel album, @RequestParam("cantante.id") Integer cantanteId) {
        album.setCantante(cantanteRepo.findById(cantanteId).orElse(null));
        albumRepo.save(album);
        return "redirect:/albums";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        AlbumModel album = albumRepo.findById(id).orElseThrow();
        model.addAttribute("album", album);
        model.addAttribute("cantantes", cantanteRepo.findAll()); // <-- Agregar esto
        return "album/form";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute AlbumModel album, @RequestParam("cantante.id") Integer cantanteId) {
        album.setId(id);
        album.setCantante(cantanteRepo.findById(cantanteId).orElse(null));
        albumRepo.save(album);
        return "redirect:/albums";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        albumRepo.deleteById(id);
        return "redirect:/albums";
    }

}
