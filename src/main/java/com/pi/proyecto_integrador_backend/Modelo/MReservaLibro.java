package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva_libro")
public class MReservaLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private MReserva reserva;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private MLibro libro;

    @Column(nullable = false)
    private Integer cantidad;

    public MReservaLibro() {}

    public MReservaLibro(MReserva reserva, MLibro libro, Integer cantidad) {
        this.reserva = reserva;
        this.libro = libro;
        this.cantidad = cantidad;
    }
}