package com.pi.proyecto_integrador_backend.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libro")
public class MLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private Long libroId;

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
    @JsonIgnore
    private List<MReservaLibro> reservaLibros;

    public MLibro() {
    }

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
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

    public List<MReservaLibro> getReservaLibros() {
        return reservaLibros;
    }

    public void setReservaLibros(List<MReservaLibro> reservaLibros) {
        this.reservaLibros = reservaLibros;
    }
}