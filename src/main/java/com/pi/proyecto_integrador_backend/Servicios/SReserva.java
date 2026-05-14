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

    // LISTAR
    public List<MReserva> listarReservas()
            throws Exception {

        try {

            return iReserva.findAll();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Optional<MReserva> encontrarReserva(
            Long id) throws Exception {

        try {

            return iReserva.findById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // GUARDAR
    public MReserva agregarReserva(
            MReserva reserva) throws Exception {

        try {

            if (reserva == null) {

                throw new Exception(
                        "La reserva no puede ser null"
                );
            }

            return iReserva.save(reserva);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminarReserva(Long id)
            throws Exception {

        try {

            if (!iReserva.existsById(id)) {

                throw new Exception(
                        "Reserva no encontrada"
                );
            }

            iReserva.deleteById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // EXISTE
    public boolean existeReserva(Long id)
            throws Exception {

        try {

            return iReserva.existsById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}