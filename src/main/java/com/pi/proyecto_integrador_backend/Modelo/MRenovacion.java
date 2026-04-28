package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "renovacion")
public class MRenovacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "renovacion_id")
    private long renovacionId;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private MReserva reserva;

    @Column(name = "fecha_renovacion", nullable = false)
    private LocalDate fechaRenovacion;

    public MRenovacion() {}

    public long getRenovacionId() {
        return renovacionId;
    }

    public void setRenovacionId(long renovacionId) {
        this.renovacionId = renovacionId;
    }
}