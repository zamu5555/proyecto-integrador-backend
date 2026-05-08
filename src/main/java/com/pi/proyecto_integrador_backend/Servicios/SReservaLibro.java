package com.pi.proyecto_integrador_backend.Servicio;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Modelo.MReservaLibro;
import com.pi.proyecto_integrador_backend.Repositorio.IReservaLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SReservaLibro {

    @Autowired
    private IReservaLibro reservaLibroRepo;

    // Lista general
    public List<MReservaLibro> listar() throws Exception {
        try {
            return reservaLibroRepo.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public MReservaLibro buscarPorId(Long id) throws Exception {
        try {
            Optional<MReservaLibro> reservaLibro = reservaLibroRepo.findById(id);
            if (reservaLibro.isPresent()) {
                return reservaLibro.get();
            } else {
                throw new Exception("ReservaLibro no encontrada con id: " + id);
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por reserva
    public List<MReservaLibro> buscarPorReserva(MReserva reserva) throws Exception {
        try {
            if (reserva == null) {
                throw new Exception("La reserva no puede ser nula");
            }
            return reservaLibroRepo.findByReserva(reserva);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Guardar
    public MReservaLibro guardar(MReservaLibro reservaLibro) throws Exception {
        try {
            if (reservaLibro == null) {
                throw new Exception("El registro ReservaLibro no puede ser nulo");
            }
            return reservaLibroRepo.save(reservaLibro);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public void eliminar(Long id) throws Exception {
        try {
            if (!reservaLibroRepo.existsById(id)) {
                throw new Exception("No se puede eliminar, ReservaLibro no encontrada con id: " + id);
            }
            reservaLibroRepo.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}