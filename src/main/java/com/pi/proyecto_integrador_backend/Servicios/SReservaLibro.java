package com.pi.proyecto_integrador_backend.Servicios;

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

    // LISTAR
    public List<MReservaLibro> listar()
            throws Exception {

        try {

            return reservaLibroRepo.findAll();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR ID
    public Optional<MReservaLibro> buscarPorId(
            Long id) throws Exception {

        try {

            return reservaLibroRepo.findById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR RESERVA
    public List<MReservaLibro> buscarPorReserva(
            MReserva reserva) throws Exception {

        try {

            return reservaLibroRepo.findByReserva(reserva);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // GUARDAR
    public MReservaLibro guardar(
            MReservaLibro reservaLibro)
            throws Exception {

        try {

            if (reservaLibro == null) {

                throw new Exception(
                        "El objeto no puede ser null"
                );
            }

            if (reservaLibro.getLibro() == null) {

                throw new Exception(
                        "Debe seleccionar un libro"
                );
            }

            if (reservaLibro.getReserva() == null) {

                throw new Exception(
                        "Debe seleccionar una reserva"
                );
            }

            return reservaLibroRepo.save(reservaLibro);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(Long id)
            throws Exception {

        try {

            if (!reservaLibroRepo.existsById(id)) {

                throw new Exception(
                        "Registro no encontrado"
                );
            }

            reservaLibroRepo.deleteById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}