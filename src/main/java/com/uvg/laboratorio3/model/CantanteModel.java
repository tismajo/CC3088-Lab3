package com.uvg.laboratorio3.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class CantanteModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(length = 50)
    private String nacionalidad;

    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "cantante")
    private List<AlbumModel> albums;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<AlbumModel> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumModel> albums) {
        this.albums = albums;
    }
}
