package com.uvg.laboratorio3.model;

import jakarta.persistence.*;
import java.time.Duration;

@Entity
public class CancionModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "cantante_id")
    private CantanteModel cantante;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private AlbumModel album;

    @Column(name = "tiempo_duracion", nullable = false)
    private String tiempoDuracionStr;

    public String getTiempoDuracionStr() {
        return tiempoDuracionStr;
    }

    public void setTiempoDuracionStr(String tiempoDuracionStr) {
        this.tiempoDuracionStr = tiempoDuracionStr;
    }

    private Duration parseTiempoDuracion(String input) {
        if (input == null || input.isEmpty()) return Duration.ZERO;

        input = input.toLowerCase();
        long minutes = 0;
        long seconds = 0;

        if (input.contains("minute")) {
            String[] parts = input.split("minute");
            minutes = Long.parseLong(parts[0].trim());
            input = parts.length > 1 ? parts[1].trim() : "";
        }

        if (input.contains("second")) {
            String[] parts = input.split("second");
            seconds = Long.parseLong(parts[0].trim());
        }

        return Duration.ofMinutes(minutes).plusSeconds(seconds);
    }

    public Duration getTiempoDuracionParsed() {
        return parseTiempoDuracion(this.tiempoDuracionStr);
    }

    @Transient
    public void setTiempoDuracion(Duration duracion) {
        long seconds = duracion.getSeconds();
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        long secs = seconds % 60;
        this.tiempoDuracionStr = String.format("%02d:%02d:%02d", hours, minutes, secs);
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FormatoAudioEnumModel formato;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private GeneroModel genero;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public CantanteModel getCantante() {
        return cantante;
    }

    public void setCantante(CantanteModel cantante) {
        this.cantante = cantante;
    }

    public AlbumModel getAlbum() {
        return album;
    }

    public void setAlbum(AlbumModel album) {
        this.album = album;
    }

    public FormatoAudioEnumModel getFormato() {
        return formato;
    }

    public void setFormato(FormatoAudioEnumModel formato) {
        this.formato = formato;
    }

    public GeneroModel getGenero() {
        return genero;
    }

    public void setGenero(GeneroModel genero) {
        this.genero = genero;
    }
}
