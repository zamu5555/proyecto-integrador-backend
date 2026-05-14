package com.pi.proyecto_integrador_backend.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "editorial")
public class MEditorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "editorial_id")
    private Long editorialId;

    @Column(name = "nombre_editorial", length = 50, nullable = false)
    private String nombreEditorial;

    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MLibro> libros;

    public MEditorial() {
    }

    public Long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Long editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    public List<MLibro> getLibros() {
        return libros;
    }

    public void setLibros(List<MLibro> libros) {
        this.libros = libros;
    }
}