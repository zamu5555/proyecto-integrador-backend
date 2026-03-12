package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")

public class MReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id", nullable = true)
    private Integer reservaId;

    @Column(name = "tipo_reserva", length = 20, nullable = true)
    private String tipoReserva;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaDevolucion;

    @Column(name = "usuario_id", nullable = false)
    private Integer usuarioId;

    public MReserva() {
    }

    public MReserva(Integer reservaId, String tipoReserva, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Integer usuarioId) {
        this.reservaId = reservaId;
        this.tipoReserva = tipoReserva;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.usuarioId = usuarioId;
    }

    public Integer getReservaId() {
        return reservaId;
    }

    public void setReservaId(Integer reservaId) {
        this.reservaId = reservaId;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(String tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }
}