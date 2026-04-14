package com.pi.proyecto_integrador_backend.Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ILibro extends JpaRepository<MLibro, Integer> {

    List<MLibro> findByNombre(String nombre);

    @Query("SELECT e FROM MLibro e WHERE e.nombre LIKE %:nombreLibro%")
    public List<MLibro> buscarPorNombre(String nombreLibro);

}
