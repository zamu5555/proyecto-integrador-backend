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

    public List<MReserva> listarReservas() {
        return iReserva.findAll();
    }

    public Optional<MReserva> encontrarReserva(Integer id) {
        return iReserva.findById(id);
    }

    public MReserva agregarReserva(MReserva reserva) {
        return iReserva.save(reserva);
    }

    public void eliminarReserva(Integer id) {
        iReserva.deleteById(id);
    }

    public boolean existeReserva(Integer id) {
        return iReserva.existsById(id);
    }
}