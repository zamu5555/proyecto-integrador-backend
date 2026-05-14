package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "renovacion")
public class MRenovacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "renovacion_id")
    private Long renovacionId;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private MReserva reserva;

    @Column(name = "fecha_renovacion", nullable = false)
    private LocalDate fechaRenovacion;

    public MRenovacion() {
    }

    public Long getRenovacionId() {
        return renovacionId;
    }

    public void setRenovacionId(Long renovacionId) {
        this.renovacionId = renovacionId;
    }

    public MReserva getReserva() {
        return reserva;
    }

    public void setReserva(MReserva reserva) {
        this.reserva = reserva;
    }

    public LocalDate getFechaRenovacion() {
        return fechaRenovacion;
    }

    public void setFechaRenovacion(LocalDate fechaRenovacion) {
        this.fechaRenovacion = fechaRenovacion;
    }
}