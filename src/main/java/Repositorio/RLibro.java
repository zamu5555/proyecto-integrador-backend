package Repositorio;

import com.pi.proyecto_integrador_backend.Modelo.MLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RLibro extends JpaRepository<MLibro, Integer> {
}
