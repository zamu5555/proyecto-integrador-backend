package com.pi.proyecto_integrador_backend.Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MEditorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEditorial
        extends JpaRepository<MEditorial, Long> {

    // BUSCAR POR NOMBRE EXACTO
    List<MEditorial> findByNombreEditorial(
            String nombreEditorial);

    // BUSCAR POR NOMBRE LIKE
    @Query("""
            SELECT e
            FROM MEditorial e
            WHERE e.nombreEditorial
            LIKE %:nombre%
            """)
    List<MEditorial> buscarPorNombre(
            String nombre);
}