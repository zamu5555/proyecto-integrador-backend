package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libro")
public class MLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "libro_id")
    private long libroId;

    @Column(length = 70, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String genero;

    @Column(length = 50, nullable = false)
    private String autor;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    private MEditorial editorial;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    private List<MReservaLibro> reservaLibros;

    public MLibro() {}

    public MLibro(long libroId, String nombre, String genero, String autor, MEditorial editorial) {
        this.libroId = libroId;
        this.nombre = nombre;
        this.genero = genero;
        this.autor = autor;
        this.editorial = editorial;
    }

    public long getLibroId() {
        return libroId;
    }

    public void setLibroId(long libroId) {
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

    public MEditorial getEditorial() {
        return editorial;
    }

    public void setEditorial(MEditorial editorial) {
        this.editorial = editorial;
    }
}