package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Dto.ReservaCompletaDto;
import com.pi.proyecto_integrador_backend.Modelo.*;
import com.pi.proyecto_integrador_backend.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SReserva {

    @Autowired
    private IReserva iReserva;

    @Autowired
    private IReservaLibro iReservaLibro;

    @Autowired
    private IUsuario iUsuario;

    @Autowired
    private ILibro iLibro;

    // LISTAR
    public List<MReserva> listarReservas() {
        try {
            return iReserva.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar reservas: " + e.getMessage());
        }
    }

    // BUSCAR
    public Optional<MReserva> encontrarReserva(Long id) {
        try {
            return iReserva.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar reserva: " + e.getMessage());
        }
    }

    public MReserva guardarReservaCompleta(ReservaCompletaDto dto) throws Exception {

        try {

            MUsuario usuario = iUsuario.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new Exception("Usuario no encontrado"));

            MLibro libro = iLibro.findById(dto.getLibroId())
                    .orElseThrow(() -> new Exception("Libro no encontrado"));

            // 1. Crear reserva
            MReserva reserva = new MReserva();
            reserva.setUsuario(usuario);
            reserva.setTipoReserva(dto.getTipoReserva());
            reserva.setFechaPrestamo(dto.getFechaPrestamo());
            reserva.setFechaDevolucion(dto.getFechaDevolucion());

            MReserva reservaGuardada = iReserva.save(reserva);

            // 2. Crear relación reserva_libro
            MReservaLibro rl = new MReservaLibro();
            rl.setReserva(reservaGuardada);
            rl.setLibro(libro);
            rl.setCantidad(1);

            iReservaLibro.save(rl);

            return reservaGuardada;

        } catch (Exception e) {
            throw new Exception("Error al guardar reserva completa: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarReserva(Long id) throws Exception {

        try {

            if (!iReserva.existsById(id)) {
                throw new Exception("Reserva no encontrada");
            }

            iReserva.deleteById(id);

        } catch (Exception e) {
            throw new Exception("Error al eliminar reserva: " + e.getMessage());
        }
    }

    public boolean existeReserva(Long id) {

        try {
            return iReserva.existsById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al verificar reserva: " + e.getMessage());
        }
    }
}