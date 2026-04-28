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

    public List<MReservaLibro> listar() {
        return reservaLibroRepo.findAll();
    }

    public Optional<MReservaLibro> buscarPorId(Long id) {
        return reservaLibroRepo.findById(id);
    }

    public List<MReservaLibro> buscarPorReserva(MReserva reserva) {
        return reservaLibroRepo.findByReserva(reserva);
    }

    public MReservaLibro guardar(MReservaLibro reservaLibro) {
        return reservaLibroRepo.save(reservaLibro);
    }

    public void eliminar(Long id) {
        reservaLibroRepo.deleteById(id);
    }
}