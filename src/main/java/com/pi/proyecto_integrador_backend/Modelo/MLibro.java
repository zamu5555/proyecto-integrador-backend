package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "libro")

public class MLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id", nullable = true)
    private Integer libroId;

    @Column(length = 70, nullable = true)
    private String nombre;

    @Column(length = 30, nullable = true)
    private String genero;

    @Column(length = 50, nullable = true)
    private String autor;

    @Column(name = "editorial_id", nullable = true)
    private Integer editorialId;

    @Column(nullable = true)
    private Integer stock;

    public MLibro() {
    }

    public MLibro(Integer libroId, String nombre, String genero, String autor, Integer editorialId, Integer stock) {
        this.libroId = libroId;
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.editorialId = editorialId;
        this.stock = stock;
    }

    public Integer getLibroId() {
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}