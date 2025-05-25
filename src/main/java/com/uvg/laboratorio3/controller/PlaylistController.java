package com.uvg.laboratorio3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uvg.laboratorio3.model.PlaylistModel;
import com.uvg.laboratorio3.repository.CancionRepository;
import com.uvg.laboratorio3.repository.PlaylistRepository;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistRepository playlistRepo;

    @Autowired
    private CancionRepository cancionRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("playlists", playlistRepo.findAll());
        return "playlist/index";
    }


    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("playlist", new PlaylistModel());
        model.addAttribute("canciones", cancionRepo.findAll()); // enviar canciones
        return "playlist/form";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        PlaylistModel playlist = playlistRepo.findById(id).orElseThrow();
        model.addAttribute("playlist", playlist);
        model.addAttribute("canciones", cancionRepo.findAll()); // enviar canciones
        return "playlist/form";
    }

    @PostMapping
    public String crear(@ModelAttribute PlaylistModel playlist) {
        playlistRepo.save(playlist);
        return "redirect:/playlists";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute PlaylistModel playlist) {
        playlist.setId(id);
        playlistRepo.save(playlist);
        return "redirect:/playlists";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        playlistRepo.deleteById(id);
        return "redirect:/playlists";
    }
}
