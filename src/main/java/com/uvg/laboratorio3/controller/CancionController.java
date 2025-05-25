package com.uvg.laboratorio3.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.uvg.laboratorio3.model.CancionModel;
import com.uvg.laboratorio3.model.FormatoAudioEnumModel;
import com.uvg.laboratorio3.repository.AlbumRepository;
import com.uvg.laboratorio3.repository.CancionRepository;
import com.uvg.laboratorio3.repository.CantanteRepository;
import com.uvg.laboratorio3.repository.GeneroRepository;

@Controller
@RequestMapping("/canciones")
public class CancionController {

    @Autowired
    private CancionRepository cancionRepo;

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private CantanteRepository cantanteRepo;

    @Autowired
    private GeneroRepository generoRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("canciones", cancionRepo.findAll());
        return "cancion/index";
    }

    @GetMapping("/nuevo")
    public String nuevoForm(Model model) {
        model.addAttribute("cancion", new CancionModel());
        model.addAttribute("albums", albumRepo.findAll());
        model.addAttribute("cantantes", cantanteRepo.findAll());
        model.addAttribute("generos", generoRepo.findAll());
        return "cancion/form";
    }

    @PostMapping
    public String crear(@RequestParam String titulo,
                        @RequestParam FormatoAudioEnumModel formato,
                        @RequestParam int horas,
                        @RequestParam int minutos,
                        @RequestParam int segundos,
                        @RequestParam Integer albumId,
                        @RequestParam Integer cantanteId,
                        @RequestParam Integer generoId) {
        CancionModel cancion = new CancionModel();
        cancion.setTitulo(titulo);
        cancion.setFormato(formato);
        cancion.setTiempoDuracion(Duration.ofHours(horas).plusMinutes(minutos).plusSeconds(segundos));
        cancion.setAlbum(albumRepo.findById(albumId).orElse(null));
        cancion.setCantante(cantanteRepo.findById(cantanteId).orElse(null));
        cancion.setGenero(generoRepo.findById(generoId).orElse(null));
        cancionRepo.save(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/editar/{id}")
    public String editarForm(@PathVariable Integer id, Model model) {
        CancionModel c = cancionRepo.findById(id).orElseThrow();
        model.addAttribute("cancion", c);
        model.addAttribute("albums", albumRepo.findAll());
        model.addAttribute("cantantes", cantanteRepo.findAll());
        model.addAttribute("generos", generoRepo.findAll());
        return "cancion/form";
    }

    @PostMapping("/editar/{id}")
    public String actualizar(@PathVariable Integer id, @ModelAttribute CancionModel cancion) {
        cancion.setId(id);
        cancionRepo.save(cancion);
        return "redirect:/canciones";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        cancionRepo.deleteById(id);
        return "redirect:/canciones";
    }
}
