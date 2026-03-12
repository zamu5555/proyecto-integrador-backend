package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "renovacion")

public class MRenovacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "renovacion_id", nullable = true)
    private Integer renovacionId;

    @Column(name = "reserva_id", nullable = false)
    private Integer reservaId;

    @Column(name = "fecha_renovacion", nullable = false)
    private LocalDate fechaRenovacion;

    public MRenovacion() {
    }

    public MRenovacion(Integer renovacionId, Integer reservaId, LocalDate fechaRenovacion) {
        this.renovacionId = renovacionId;
        this.reservaId = reservaId;
        this.fechaRenovacion = fechaRenovacion;
    }

    public Integer getRenovacionId() {
        return renovacionId;
    }

    public void setRenovacionId(Integer renovacionId) {
        this.renovacionId = renovacionId;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public LocalDate getFechaRenovacion() {
        return fechaRenovacion;
    }

    public void setFechaRenovacion(LocalDate fechaRenovacion) {
        this.fechaRenovacion = fechaRenovacion;
    }
}