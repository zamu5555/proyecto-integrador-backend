package com.pi.proyecto_integrador_backend.Modelo;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class MUsuario {

    @Id
    @Column(name = "usuario_id")
    private long usuarioId;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String documento;

    @Column(length = 30)
    private String telefono;

    @Column(length = 40)
    private String correo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<MReserva> reservas;

    public MUsuario() {}

    public MUsuario(long usuarioId, String nombre, String documento, String telefono, String correo) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}