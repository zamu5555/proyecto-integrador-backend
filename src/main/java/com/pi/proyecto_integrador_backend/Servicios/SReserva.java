package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Repositorio.IReserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SReserva {

    @Autowired
    private IReserva iReserva;

    // Lista general
    public List<MReserva> listarReservas() throws Exception {
        try {
            return iReserva.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public MReserva encontrarReserva(Integer id) throws Exception {
        try {
            Optional<MReserva> reserva = iReserva.findById(id);
            if (reserva.isPresent()) {
                return reserva.get();
            } else {
                throw new Exception("Reserva no encontrada con id: " + id);
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Agregar reserva
    public MReserva agregarReserva(MReserva reserva) throws Exception {
        try {
            if (reserva == null) {
                throw new Exception("La reserva no puede ser nula");
            }
            return iReserva.save(reserva);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar reserva
    public void eliminarReserva(Integer id) throws Exception {
        try {
            if (!iReserva.existsById(id)) {
                throw new Exception("No se puede eliminar, reserva no encontrada con id: " + id);
            }
            iReserva.deleteById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Verificar existencia
    public boolean existeReserva(Integer id) throws Exception {
        try {
            return iReserva.existsById(id);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}