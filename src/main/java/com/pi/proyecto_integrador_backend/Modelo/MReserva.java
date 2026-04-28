package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
public class MReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reserva_id")
    private long reservaId;

    @Column(name = "tipo_reserva", length = 20)
    private String tipoReserva;

    @Column(name = "fecha_prestamo", nullable = false)
    private LocalDate fechaPrestamo;

    @Column(name = "fecha_devolucion", nullable = false)
    private LocalDate fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private MUsuario usuario;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<MRenovacion> renovaciones;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<MReservaLibro> reservaLibros;

    public MReserva() {}

    public long getReservaId() {
        return reservaId;
    }

    public void setReservaId(long reservaId) {
        this.reservaId = reservaId;
    }
}