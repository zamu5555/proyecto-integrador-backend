package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva_libro")

public class MReservaLibro {

    @Id
    @Column(name = "reserva_id", nullable = true)
    private Integer reservaId;

    @Id
    @Column(name = "libro_id", nullable = false)
    private Integer libroId;

    @Column(nullable = false)
    private Integer cantidad;

    public MReservaLibro() {
    }

    public MReservaLibro(Integer reservaId, Integer libroId, Integer cantidad) {
        this.reservaId = reservaId;
        this.libroId = libroId;
        this.cantidad = cantidad;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}