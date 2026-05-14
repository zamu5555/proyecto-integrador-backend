package com.pi.proyecto_integrador_backend.Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuario
        extends JpaRepository<MUsuario, Long> {

    // BUSCAR POR DOCUMENTO
    Optional<MUsuario> findByDocumento(
            String documento);
}