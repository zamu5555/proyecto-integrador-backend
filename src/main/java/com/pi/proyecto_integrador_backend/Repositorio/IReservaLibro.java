package com.pi.proyecto_integrador_backend.Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MReserva;
import com.pi.proyecto_integrador_backend.Modelo.MReservaLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReservaLibro extends JpaRepository<MReservaLibro, Long> {

    List<MReservaLibro> findByReserva(MReserva reserva);

}