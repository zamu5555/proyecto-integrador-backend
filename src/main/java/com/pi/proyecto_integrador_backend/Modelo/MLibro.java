package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")

public class MLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "libro_id", nullable = true)
    private long libroId;

    @Column(length = 70, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String genero;

    @Column(length = 50, nullable = false)
    private String autor;

    @Column(name = "editorial_id", nullable = true)
    private Integer editorialId;

    public MLibro() {
    }

    public MLibro(Integer libroId, String nombre, String genero, String autor, Integer editorialId) {
        this.libroId = libroId;
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.editorialId = editorialId;
    }

    public long getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }
}