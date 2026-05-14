package com.pi.proyecto_integrador_backend.Modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reserva")
public class MReserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserva_id")
    private Long reservaId;

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
    @JsonIgnore
    private List<MRenovacion> renovaciones;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MReservaLibro> reservaLibros;

    public MReserva() {
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
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

    public MUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(MUsuario usuario) {
        this.usuario = usuario;
    }

    public List<MRenovacion> getRenovaciones() {
        return renovaciones;
    }

    public void setRenovaciones(List<MRenovacion> renovaciones) {
        this.renovaciones = renovaciones;
    }

    public List<MReservaLibro> getReservaLibros() {
        return reservaLibros;
    }

    public void setReservaLibros(List<MReservaLibro> reservaLibros) {
        this.reservaLibros = reservaLibros;
    }
}