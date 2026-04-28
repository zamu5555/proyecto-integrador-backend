package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "editorial")
public class MEditorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "editorial_id")
    private long editorialId;

    @Column(name = "nombre_editorial", length = 50, nullable = false)
    private String nombreEditorial;

    @OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL)
    private List<MLibro> libros;

    public MEditorial() {}

    public MEditorial(long editorialId, String nombreEditorial) {
        this.editorialId = editorialId;
        this.nombreEditorial = nombreEditorial;
    }

    public long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(long editorialId) {
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