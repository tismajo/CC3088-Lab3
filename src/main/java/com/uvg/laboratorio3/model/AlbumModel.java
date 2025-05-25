package com.uvg.laboratorio3.model;

import jakarta.persistence.*;

@Entity
public class AlbumModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    private Integer anio;

    @ManyToOne
    @JoinColumn(name = "cantante_id")
    private CantanteModel cantante;

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

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public CantanteModel getCantante() {
        return cantante;
    }

    public void setCantante(CantanteModel cantante) {
        this.cantante = cantante;
    }
}
