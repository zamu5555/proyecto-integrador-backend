package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva_libro")
public class MReservaLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private MReserva reserva;

    @ManyToOne
    @JoinColumn(name = "libro_id", nullable = false)
    private MLibro libro;

    @Column(nullable = false)
    private Integer cantidad;

    public MReservaLibro() {
    }

    public MReservaLibro(MReserva reserva, MLibro libro, Integer cantidad) {
        this.reserva = reserva;
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return id;
    }

    public MReserva getReserva() {
        return reserva;
    }

    public void setReserva(MReserva reserva) {
        this.reserva = reserva;
    }

    public MLibro getLibro() {
        return libro;
    }

    public void setLibro(MLibro libro) {
        this.libro = libro;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}