package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "editorial")

public class MEditorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "editorial_id")
    private long editorialId;

    @Column(name = "nombre_editorial", length = 50, nullable = false)
    private String nombreEditorial;

    public MEditorial() {
    }

    public MEditorial(Integer editorialId, String nombreEditorial) {
        this.editorialId = editorialId;
        this.nombreEditorial = nombreEditorial;
    }

    public long getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }
}