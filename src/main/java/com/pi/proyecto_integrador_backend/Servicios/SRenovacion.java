package com.pi.proyecto_integrador_backend.Servicios;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import com.pi.proyecto_integrador_backend.Repositorio.IReserva;
import com.pi.proyecto_integrador_backend.Repositorio.IRenovacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SRenovacion {

    @Autowired
    private IRenovacion iRenovacion;

    @Autowired
    private IReserva iReserva;

    // LISTA GENERAL
    public List<MRenovacion> listarRenovaciones() throws Exception {

        try {

            return iRenovacion.findAll();

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // BUSCAR POR FECHA
    public List<MRenovacion> consultarPorFechaRenovacion(
            LocalDate fechaRenovacion) throws Exception {

        try {

            return iRenovacion
                    .findByFechaRenovacion(fechaRenovacion);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // GUARDAR
    public MRenovacion guardar(
            MRenovacion renovacion) throws Exception {

        try {

            if (renovacion == null) {

                throw new Exception(
                        "La renovacion no puede ser null"
                );
            }

            if (renovacion.getReserva() == null) {

                throw new Exception(
                        "La reserva es obligatoria"
                );
            }

            Long reservaId =

                    renovacion
                            .getReserva()
                            .getReservaId();

            MReserva reserva =

                    iReserva.findById(reservaId)
                            .orElseThrow(() ->
                                    new Exception(
                                            "Reserva no encontrada"
                                    )
                            );

            LocalDate nuevaFecha =

                    reserva
                            .getFechaDevolucion()
                            .plusDays(7);

            reserva.setFechaDevolucion(
                    nuevaFecha
            );

            iReserva.save(reserva);

            renovacion.setReserva(reserva);

            return iRenovacion.save(
                    renovacion
            );

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(Long id) throws Exception {

        try {

            if (!iRenovacion.existsById(id)) {

                throw new Exception(
                        "Renovacion no encontrada"
                );
            }

            iRenovacion.deleteById(id);

        } catch (Exception e) {

            throw new Exception(e.getMessage());
        }
    }
}