package com.pi.proyecto_integrador_backend.Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MRenovacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRenovacion
        extends JpaRepository<MRenovacion, Long> {

    // BUSCAR POR FECHA
    List<MRenovacion> findByFechaRenovacion(
            LocalDate fechaRenovacion);
}